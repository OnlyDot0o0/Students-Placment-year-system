package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFPlacementProviderNamedContact;
import org.springframework.data.repository.CrudRepository;


public interface PPFPNamedContactRepo extends CrudRepository<PPFPlacementProviderNamedContact,Integer> {

    PPFPlacementProviderNamedContact findByStudent_StudentNumber(String id);
}
