package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PolicyAndInsurance;
import org.springframework.data.repository.CrudRepository;

public interface PolicyAndInsuranceRepository extends CrudRepository<PolicyAndInsurance,Integer> {
    PolicyAndInsurance findByStudent_StudentNumber(String id);
}
