package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFhealth;
import org.springframework.data.repository.CrudRepository;


public interface PPFHealthRepo extends CrudRepository<PPFhealth,Integer> {


}
