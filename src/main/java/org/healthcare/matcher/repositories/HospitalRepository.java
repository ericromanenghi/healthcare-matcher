package org.healthcare.matcher.repositories;

import org.healthcare.matcher.entities.api.Hospital;
import org.healthcare.matcher.repositories.daos.HospitalDao;

public class HospitalRepository {
    private final HospitalDao dao;

    public HospitalRepository(final HospitalDao dao) {
        this.dao = dao;
    }


    public Hospital get(int id) {
        final org.healthcare.matcher.entities.db.Hospital src = dao.getHospital(id);
        return Hospital.from(src);
    }
}
