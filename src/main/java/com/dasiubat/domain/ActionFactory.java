package com.dasiubat.domain;

import com.dasiubat.domain.actions.Action;
import com.dasiubat.domain.enums.ActionType;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adam-bat-usr on 25/09/2014.
 */
@Component
public class ActionFactory {
    // TODO wire userService

    public Action create(List<String> modifiedProperties) {
        ActionType actionType = actionTypeInference(modifiedProperties);
        Action action = new Action();
        return new Action();
    }

    private ActionType actionTypeInference(final List<String> modifiedProperties) {
        try {
            return Iterables.find(Arrays.asList(ActionType.values()),
                    new Predicate<ActionType>() {
                        @Override
                        public boolean apply(ActionType actionType) {
                            return actionType.getModifiedProperties().equals(modifiedProperties);
                        }
                    });
        } catch (NullPointerException e) {
            throw new ActionTypeNotFound();
        }
    }

    private List<List<String>> propertiesModifiedByEachAction() {
        return Lists.transform(Arrays.asList(ActionType.values()), new Function<ActionType, List<String>>() {
            @Override
            public List<String> apply(ActionType type) {
                return type.getModifiedProperties();
            }
        });
    }
}
