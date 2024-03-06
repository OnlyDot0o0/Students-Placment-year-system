package com.group14.placementtrackingsystem.model;
//By Abdulqader and Maryam
//This is the Role model class which holds the attributes that are filled out
//in the third section of the Student Authorisation Placement Request Form.
//Contains : roleStartDate, roleEndDate, workingHoursWeek, probationPeriod, probationLength,
//annualSalary, roleSource,providerInformedDegree, roleDescription


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class Role {

    //These attributes contain the third section details filled out by the student in the form
    @Id
    @GeneratedValue
    private int id;
    private String roleTitle;

    private Date roleStartDate;

    private Date roleEndDate;

    private String ppfStudentName;

    private float workingHoursWeek;

    private boolean probationPeriod;

    private String probationLength ;

    private String probationAssessment;

    private int annualSalary;

    private String annualSalaryRange;

    public String getAnnualSalaryRange() {
        return annualSalaryRange;
    }

    public void setAnnualSalaryRange(String annualSalaryRange) {
        this.annualSalaryRange = annualSalaryRange;
    }

    private String roleSource ;

    private Boolean providerInformedDegree = false;

    private String roleDescription;

    private String Achievement;
    @OneToOne
    private Student student;

    @OneToOne
    private PPFPlacementProviderDetails company;

    public String getPpfStudentName() {
        return ppfStudentName;
    }

    public void setPpfStudentName(String ppfStudentName) {
        this.ppfStudentName = ppfStudentName;
    }

    //Below contains getters, setters and toString methods

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public Date getRoleStartDate() {
        return roleStartDate;
    }

    public void setRoleStartDate(Date roleStartDate) {
        this.roleStartDate = roleStartDate;
    }

    public Date getRoleEndDate() {
        return roleEndDate;
    }

    public void setRoleEndDate(Date roleEndDate) {
        this.roleEndDate = roleEndDate;
    }

    public float getWorkingHoursWeek() {
        return workingHoursWeek;
    }

    public void setWorkingHoursWeek(float workingHoursWeek) {
        this.workingHoursWeek = workingHoursWeek;
    }

    public boolean isProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(boolean probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public String getProbationLength() {
        return probationLength;
    }

    public void setProbationLength(String probationLength) {
        this.probationLength = probationLength;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String getRoleSource() {
        return roleSource;
    }

    public void setRoleSource(String roleSource) {
        this.roleSource = roleSource;
    }

    public Boolean getProviderInformedDegree() {
        return providerInformedDegree;
    }

    public void setProviderInformedDegree(Boolean providerInformedDegree) {
        this.providerInformedDegree = providerInformedDegree;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getProbationAssessment() {
        return probationAssessment;
    }

    public void setProbationAssessment(String probationAssessment) {
        this.probationAssessment = probationAssessment;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }

    public String getAchievement() {
        return Achievement;
    }

    public void setAchievement(String achievement) {
        Achievement = achievement;
    }

    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleTitle='" + roleTitle + '\'' +
                ", roleStartDate=" + roleStartDate +
                ", roleEndDate=" + roleEndDate +
                ", workingHoursWeek=" + workingHoursWeek +
                ", probationPeriod=" + probationPeriod +
                ", probationLength='" + probationLength + '\'' +
                ", annualSalary=" + annualSalary +
                ", roleSource='" + roleSource + '\'' +
                ", providerInformedDegree=" + providerInformedDegree +
                ", roleDescription='" + roleDescription + '\'' +
                ", student=" + student +
                '}';
    }
}
