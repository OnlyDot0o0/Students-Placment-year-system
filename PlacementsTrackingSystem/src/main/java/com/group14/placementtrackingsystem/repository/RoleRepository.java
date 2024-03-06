package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Integer> {
//    @Query("SELECT a FROM Role a WHERE a.annualSalary <= :today AND a.annualSalary >= :today")
    @Query("SELECT AVG(e.annualSalary) FROM Role e")
    public Integer findALlSalary();

    @Query("SELECT AVG(e.annualSalary) FROM Role e WHERE e.company.id = :co")
    public Integer findAVGSalaryByCompany(@Param("co") int company);

    public Role findByStudent_StudentNumber(String id);
}