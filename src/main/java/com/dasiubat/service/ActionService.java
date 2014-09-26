package com.dasiubat.service;

import com.dasiubat.domain.ActionToPropertiesException;
import com.dasiubat.domain.BaseModel;
import com.dasiubat.domain.actions.Action;
import com.dasiubat.domain.actions.ActionNotRelatedToCase;
import com.dasiubat.domain.actions.ActionRelatedToCase;
import com.dasiubat.domain.actions.AttributeHistoryEntry;
import com.dasiubat.repository.ActionRepository;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.sun.istack.internal.NotNull;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
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

    List<String> actionProperties = Arrays.asList("title");

    // TODO t extends base model
    public void audit(@NotNull ActionNotRelatedToCase action,
                      @NotNull Class<? extends BaseModel> modelType,
                      @NotNull BaseModel model) {
        action.setModel(model);
        audit(action, modelType);
    }

    // TODO case obj
    public void audit(@NotNull ActionRelatedToCase actionRelatedToCase,
                      @NotNull Class<? extends BaseModel> modelType,
                      @NotNull BaseModel model,
                      @NotNull Object aCase) {
        actionRelatedToCase.setModel(model);
        // TODO set case
        audit(actionRelatedToCase, modelType);
    }

    private void audit(final Action action, Class<? extends BaseModel> type) {
        BaseModel modifiedModel = action.getModel();
        BaseModel originalModel = actionRepository.findInSeparateSession(type, 1L); // TODO check if original exists

        List<String> modifiedProperties = modifiedProperties(originalModel, modifiedModel);

        List<AttributeHistoryEntry> modificationHistoryForAction = modificationHistoryForAction(action,
                modifiedProperties, originalModel, modifiedModel);

        actionRepository.save(action);

        for (AttributeHistoryEntry attributeHistoryEntry : modificationHistoryForAction) {
            System.out.println("sf");
        }

        System.out.println("sf");
        // save action
        // save attributes
    }

    private List<AttributeHistoryEntry> modificationHistoryForAction(
            final Action action,
            final List<String> modifiedProperties,
            final BaseModel originalModel,
            final BaseModel modifiedModel) {
        final Map<String, String> originalPropertiesStringified = propertiesToString(modifiedProperties, originalModel);
        final Map<String, String> modifiedPropertiesStringified = propertiesToString(modifiedProperties, modifiedModel);
        return Lists.transform(modifiedProperties,
                new Function<String, AttributeHistoryEntry>() {
                    @Override
                    public AttributeHistoryEntry apply(String property) {
                        System.out.println("ssdf");

                        String oldValue = action.propertyToString(originalModel, property);
                        String newValue = action.propertyToString(modifiedModel, property);

                        return createAttributeHistoryEntry(action, property, oldValue, newValue);
                    }
                });
    }

    private AttributeHistoryEntry createAttributeHistoryEntry(Action action, String property, String oldValue,
                                                              String newValue) {
        AttributeHistoryEntry attributeHistoryEntry = new AttributeHistoryEntry();
        attributeHistoryEntry.setAction(action);
        attributeHistoryEntry.setName(property);
        attributeHistoryEntry.setOldValue(oldValue);
        attributeHistoryEntry.setNewValue(newValue);
        return attributeHistoryEntry;
    }

    private Map<String, String> propertiesToString(List<String> properties, BaseModel model) {

        // for each property
        // call overridden method propertyToString
        // switch (property)
        // id => map put property, id
        // creationDate => map put property, id
        return null;
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
            throw new ActionToPropertiesException(e);
        }

        return modifiedProperties;
    }

    private boolean isModified(String property, Map<String, Object> first, Map<String, Object> second) {
        Object firstVal = first.get(property);
        Object secondVal = second.get(property);

        return !(firstVal == null ? secondVal == null : firstVal.equals(secondVal));
    }
}
