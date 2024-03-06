package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.HealthEnvironmentalFactors;
import org.springframework.data.repository.CrudRepository;

public interface HealthEnvironmentalFactorsRepository extends CrudRepository<HealthEnvironmentalFactors, Integer> {

    HealthEnvironmentalFactors findByStudent_StudentNumber(String id);
}