package com.dasiubat.service;

import com.dasiubat.domain.ListModelPropertiesException;
import com.dasiubat.domain.BaseModel;
import com.dasiubat.domain.ModelCannotBeConvertedToString;
import com.dasiubat.domain.ModelReference;
import com.dasiubat.domain.actions.Action;
import com.dasiubat.domain.actions.ActionNotRelatedToCase;
import com.dasiubat.domain.actions.ActionRelatedToCase;
import com.dasiubat.domain.actions.AttributeHistoryEntry;
import com.dasiubat.repository.ActionRepository;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.PropertyUtils;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2014-05-06.
 */

@Service
@Transactional
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

    public <T extends BaseModel> void audit(@NotNull ActionNotRelatedToCase<T> action,
                                            @NotNull Class<? extends T> modelType,
                                            @NotNull T model) {
        auditHelper(action, modelType, model);
    }

    // TODO case obj
    public <T extends BaseModel> void audit(@NotNull ActionRelatedToCase<T> actionRelatedToCase,
                                            @NotNull Class<? extends T> modelType,
                                            @NotNull T model,
                                            @NotNull Object aCase) {
        // TODO set case
        auditHelper(actionRelatedToCase, modelType, model);
    }

    private <T extends BaseModel> void auditHelper(final Action<T> action, Class<? extends T> type, T modifiedModel) {
        if (isModelNew(modifiedModel)) {
            return;
        }

        prepareAction(action, type, modifiedModel);
        actionRepository.save(action);
        saveHistory(modificationHistory(action, type, modifiedModel));

        System.out.println("sf");
        // save action
    }

    private void saveHistory(List<AttributeHistoryEntry> attributeHistoryEntries) {
        for (AttributeHistoryEntry attributeHistoryEntry : attributeHistoryEntries) {
            System.out.println(attributeHistoryEntry);
            // save attributes
        }
    }

    private <T extends BaseModel> void prepareAction(Action<T> action, Class<? extends T> type, T modifiedModel) {
        setModelReference(action, type, modifiedModel);
    }

    private <T extends BaseModel> boolean isModelNew(T model) {
        return model.getId() == null; // TODO in others case getid shouldnt be 0
    }

    private <T extends BaseModel> void setModelReference(Action<T> action, Class<? extends T> type, T modifiedModel) {
        ModelReference modelReference = new ModelReference();
        modelReference.setModelId(modifiedModel.getId().intValue());
        modelReference.setModelType(type.getSimpleName());
        action.setModelReference(modelReference);
    }

    private <T extends BaseModel> List<AttributeHistoryEntry> modificationHistory(
            final Action<T> action, Class<? extends T> type, final T modifiedModel) {
        final T originalModel = actionRepository.findInSeparateSession(type, 1L);
        return Lists.transform(modifiedProperties(originalModel, modifiedModel),
                new Function<String, AttributeHistoryEntry>() {
                    @Override
                    public AttributeHistoryEntry apply(String property) {
                        try {
                            String oldValue = action.propertyToString(originalModel, property);
                            String newValue = action.propertyToString(modifiedModel, property);

                            return createAttributeHistoryEntry(action, property, oldValue, newValue);
                        } catch (NullPointerException e) {
                            throw new ModelCannotBeConvertedToString();
                        }
                    }
                });
    }

    private <T extends BaseModel> AttributeHistoryEntry createAttributeHistoryEntry(Action<T> action, String property,
                                                                                    @NotNull String oldValue,
                                                                                    @NotNull String newValue) {
        AttributeHistoryEntry attributeHistoryEntry = new AttributeHistoryEntry();
        attributeHistoryEntry.setAction(action);
        attributeHistoryEntry.setName(property);
        attributeHistoryEntry.setOldValue(oldValue);
        attributeHistoryEntry.setNewValue(newValue);
        return attributeHistoryEntry;
    }

    private List<String> modifiedProperties(BaseModel firstModel, BaseModel secondModel) {
        List<String> modifiedProperties = new ArrayList<>();
        try {
            Map<String, Object> firstDecoupled = PropertyUtils.describe(firstModel);
            Map<String, Object> secondDecoupled = PropertyUtils.describe(secondModel);
            for (String property : firstDecoupled.keySet()) {
                if (isModified(property, firstDecoupled, secondDecoupled)) {
                    modifiedProperties.add(property);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ListModelPropertiesException();
        }

        return modifiedProperties;
    }

    private boolean isModified(String property, Map<String, Object> first, Map<String, Object> second) {
        Object firstVal = first.get(property);
        Object secondVal = second.get(property);

        return !(firstVal == null ? secondVal == null : firstVal.equals(secondVal));
    }
}
