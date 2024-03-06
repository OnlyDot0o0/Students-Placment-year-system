package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFWorkFactors;
import com.group14.placementtrackingsystem.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PPFWorkFactorsRepo extends CrudRepository<PPFWorkFactors,Integer> {

    public PPFWorkFactors findByStudent_StudentNumber(String id);

    @Query("SELECT AVG(e.annualSalary) FROM Role e WHERE e.company.id = :co")
    public Integer findAVGSalaryByCompany(@Param("co") int company);

    public List<PPFWorkFactors> findAllByRemoteWorkEquals(Byte theNum);



}
