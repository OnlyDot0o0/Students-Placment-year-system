package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/*
By Maryam. This file was created in order to save certain details from the
old Excel Master Tracker database to our new system database
 */
@Entity
public class StudentFinanceTeam {
    @Id
    @GeneratedValue
    private int id;

    //Area for student finance to make any notes relating to the placement
    private String studentFinanceTeamNotes;

    @OneToOne
    private Student student;

    //Getter and setter methods

    public String getStudentFinanceTeamNotes() {
        return studentFinanceTeamNotes;
    }

    public void setStudentFinanceTeamNotes(String studentFinanceTeamNotes) {
        this.studentFinanceTeamNotes = studentFinanceTeamNotes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
