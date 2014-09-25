package com.dasiubat.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum ActionType {
    CASE_MODIFIED(Arrays.asList("title"), true),
    USER_ASSIGNED_TO_CASE(Arrays.asList(""), true),
    CALENDAR_EDITED(Arrays.asList(""), false);

    private final boolean isConnectedWithCase;
    private final List<String> modifiedProperties;

    private ActionType(List<String> modifiedProperties, boolean isConnectedWithCase) {
        this.modifiedProperties = modifiedProperties;
        this.isConnectedWithCase = isConnectedWithCase;
    }

    public boolean isConnectedWithCase() {
        return isConnectedWithCase;
    }

    public List<String> getModifiedProperties() {
        return modifiedProperties;
    }
}
