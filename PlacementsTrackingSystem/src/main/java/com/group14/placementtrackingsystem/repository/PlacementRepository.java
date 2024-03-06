package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
/*
this is the placement repository created by Zaina and Moaz.
This repository helps us know which student is currently on student by comparing
if today's date is in between the starting date of when the student gets the placement and
the ending date when the student finishes his placement
the @Query function helps us use this like we are searching this in the sql database
 */
public interface PlacementRepository extends CrudRepository<Placement, Integer> {

    @Query("SELECT a FROM Placement a WHERE a.role.roleStartDate <= :today AND a.role.roleEndDate >= :today")
    List<Placement> findStudentByOnPlacement(@Param("today") Date today); //specifies the name for a method parameter

     Placement findByStudent(Student student);

     boolean existsByStudent(Student student);

    /**
     * @param id an integer to decide the approval status : 0 WAITING APPROVAL, 1 APPROVED , 2 FLAGGED, 3 REJECTED
     * **/
    @Query(value = "SELECT * FROM placement_students WHERE approval_status = :id", nativeQuery = true)
     List<Placement> findAllByApprovalStatus(@Param("id") int  id);

     List<Placement> findAllByCompany(PPFPlacementProviderDetails comp);


     List<PPFPlacementProviderDetails> findDistinctByCompanyNotIn(List<String> companies);

}
