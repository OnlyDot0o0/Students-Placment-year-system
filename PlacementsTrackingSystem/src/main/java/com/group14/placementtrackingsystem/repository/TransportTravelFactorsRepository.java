package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.TransportTravelFactors;
import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface TransportTravelFactorsRepository extends CrudRepository<TransportTravelFactors, Integer> {
    public TransportTravelFactors findByStudent_StudentNumber(String id);

    public List<TransportTravelFactors> findAllByOverseasPlacementEquals(Boolean checkit);

}