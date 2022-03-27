package org.healthcare.matcher.repositories.daos;

import org.healthcare.matcher.entities.db.SpecializedUnit;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface SpecializedUnitDao {
    @SqlQuery("SELECT * FROM specialized_units WHERE id in (<ids>)")
    @RegisterConstructorMapper(SpecializedUnit.class)
    List<SpecializedUnit> getUnits(@BindList(value = "ids", onEmpty = BindList.EmptyHandling.NULL_STRING) List<Integer> ids);
}
