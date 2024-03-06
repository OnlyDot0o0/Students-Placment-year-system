package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.Student;
import org.springframework.data.repository.CrudRepository;
import com.group14.placementtrackingsystem.model.DatesOfFormCompletions;

//was not working without the arrows for some reason
public interface DatesofFormCompletionRepository extends CrudRepository<DatesOfFormCompletions, Integer> {
    public DatesOfFormCompletions findByStudent(Student student);

}
