package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PPFProviderDetailsRepo extends CrudRepository<PPFPlacementProviderDetails, Integer> {
    public PPFPlacementProviderDetails findById(int id);

    public PPFPlacementProviderDetails findByStudent_StudentNumber(String id);

    public PPFPlacementProviderDetails findByOrganisationName(String name);
}
