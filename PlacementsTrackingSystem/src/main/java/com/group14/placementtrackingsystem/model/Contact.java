package com.group14.placementtrackingsystem.model;

//By Maryam. A contact model class to make it easier to pass
//the attributes around in the controller

public class Contact {
    private String emailTo;
    private String Subject;
    private String body;

    //Getters, setters and toString method below
    @Override
    public String toString() {
        return "Contact{" +
                "emailTo='" + emailTo + '\'' +
                ", Subject='" + Subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
