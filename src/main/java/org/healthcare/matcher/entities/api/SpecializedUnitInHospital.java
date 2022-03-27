package org.healthcare.matcher.entities.api;

import lombok.Value;
import org.healthcare.matcher.entities.db.SpecializedUnitMapItem;

@Value
public class SpecializedUnitInHospital {
    int id;
    String name;
    boolean active;

    public static SpecializedUnitInHospital from(final org.healthcare.matcher.entities.db.SpecializedUnit src, final SpecializedUnitMapItem hospitalRelation) {
        if (src == null || hospitalRelation == null) {
            return null;
        }
        return new SpecializedUnitInHospital(src.getId(), src.getName(), hospitalRelation.isActive());
    }
}

