package com.group14.placementtrackingsystem.repository;

import com.group14.placementtrackingsystem.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    public Student findByStudentNumber(String studentNumber);
    public Student findByFirstNameAndSurname(String firstName, String surname);

    public List<Student> findAllByStudentStatus(String Dtype);
    public List<Student> findAll();


}
