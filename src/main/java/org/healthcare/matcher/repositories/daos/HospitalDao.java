package org.healthcare.matcher.repositories.daos;

import org.healthcare.matcher.entities.db.Hospital;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface HospitalDao {
    @SqlQuery("SELECT * FROM hospitals WHERE id = :id")
    @RegisterConstructorMapper(Hospital.class)
    Hospital getHospital(@Bind("id") int id);
}
