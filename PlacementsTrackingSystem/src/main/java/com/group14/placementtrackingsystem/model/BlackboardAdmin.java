package com.group14.placementtrackingsystem.model;
/*
By Maryam. This file was created in order to save certain details from the
old Excel Master Tracker database to our new system database
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BlackboardAdmin {
    @Id
    @GeneratedValue
    private int id;

    //Confirm that the student has been added to the
    //on-placement module on blackboard
    private String on_placementModule;

    //Confirm that the student has been added to the
    //on-placement blackboard group
    private String on_placementGroup;

    //Confirm that the student has been emailed
    //to confirm the changed in blackboard
    private String studentEmailed;

    @OneToOne
    private Student student;

    @OneToOne
    private MonitoringAndEvaluation monitoringAndEvaluation;

    //Getter and setter methods
    public String getOn_placementModule() {
        return on_placementModule;
    }

    public void setOn_placementModule(String on_placementModule) {
        this.on_placementModule = on_placementModule;
    }

    public String getOn_placementGroup() {
        return on_placementGroup;
    }

    public void setOn_placementGroup(String on_placementGroup) {
        this.on_placementGroup = on_placementGroup;
    }

    public String getStudentEmailed() {
        return studentEmailed;
    }

    public void setStudentEmailed(String studentEmailed) {
        this.studentEmailed = studentEmailed;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public MonitoringAndEvaluation getMonitoringAndEvaluation() {
        return monitoringAndEvaluation;
    }

    public void setMonitoringAndEvaluation(MonitoringAndEvaluation monitoringAndEvaluation) {
        this.monitoringAndEvaluation = monitoringAndEvaluation;
    }
}
