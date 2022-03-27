package org.healthcare.matcher.repositories;

import org.healthcare.matcher.entities.api.Hospital;
import org.healthcare.matcher.entities.api.SpecializedUnitInHospital;
import org.healthcare.matcher.entities.db.SpecializedUnitMapItem;
import org.healthcare.matcher.repositories.daos.HospitalDao;
import org.healthcare.matcher.repositories.daos.SpecializedUnitDao;
import org.healthcare.matcher.repositories.daos.SpecializedUnitMapDao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;


public class HospitalRepository {
    private final HospitalDao hospitalDao;
    private final SpecializedUnitDao specializedUnitDao;
    private final SpecializedUnitMapDao specializedUnitMapDao;

    public HospitalRepository(final HospitalDao dao, final SpecializedUnitDao specializedUnitDao, final SpecializedUnitMapDao specializedUnitMapDao) {
        this.hospitalDao = dao;
        this.specializedUnitDao = specializedUnitDao;
        this.specializedUnitMapDao = specializedUnitMapDao;
    }


    public Hospital get(int id) {
        final org.healthcare.matcher.entities.db.Hospital src = hospitalDao.getHospital(id);

        final List<SpecializedUnitMapItem> specializedUnitMapItems = specializedUnitMapDao.getMapItemsByHospitalId(id);
        final List<Integer> specializedUnitIds = specializedUnitMapItems.stream()
                .map(SpecializedUnitMapItem::getUnitId)
                .distinct()
                .toList();

        final List<org.healthcare.matcher.entities.db.SpecializedUnit> specializedUnits = specializedUnitDao.getUnits(specializedUnitIds);
        final Map<Integer, org.healthcare.matcher.entities.db.SpecializedUnit> specializedUnitsById = specializedUnits.stream().collect(toMap(
                org.healthcare.matcher.entities.db.SpecializedUnit::getId,
                i -> i
        ));

        Set<SpecializedUnitInHospital> specializedUnitsInHospital = specializedUnitMapItems.stream()
                .map(i -> SpecializedUnitInHospital.from(specializedUnitsById.get(i.getUnitId()), i))
                .collect(toSet());

        return Hospital.from(src, specializedUnitsInHospital);
    }
}
