package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.LocationRegionalFactors;
import org.springframework.data.repository.CrudRepository;

public interface LocationRegionalFactorsRepository extends CrudRepository<LocationRegionalFactors, Integer> {

    LocationRegionalFactors findByStudent_StudentNumber(String id);
}