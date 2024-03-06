package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PersonalFactors;
import org.springframework.data.repository.CrudRepository;

public interface PersonalFactorsRepository extends CrudRepository<PersonalFactors, Integer> {
    PersonalFactors findByStudent_StudentNumber(String id);
}
