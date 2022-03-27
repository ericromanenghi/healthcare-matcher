package org.healthcare.matcher.repositories.daos;

import org.healthcare.matcher.entities.db.SpecializedUnit;
import org.healthcare.matcher.entities.db.SpecializedUnitMapItem;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface SpecializedUnitMapDao {
    @SqlQuery("SELECT * FROM hospital_specialized_units_map WHERE hospital_id = :hospitalId")
    @RegisterConstructorMapper(SpecializedUnitMapItem.class)
    List<SpecializedUnitMapItem> getMapItemsByHospitalId(@Bind("hospitalId") Integer hospitalId);
}
