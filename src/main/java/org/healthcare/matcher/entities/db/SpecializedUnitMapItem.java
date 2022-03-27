package org.healthcare.matcher.entities.db;

import lombok.Value;

@Value
public class SpecializedUnitMapItem {
    int hospitalId;
    int unitId;
    boolean active;
}

