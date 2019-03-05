package com.harmonycloud.bo;

import java.util.Date;

public class PatientBo {
    private String name;
    private String patientDocType;
    private String patientDocNum;
    private Date dateOfBirth;
    private String  year;
    private String sex;

    public PatientBo() {
    }

    public PatientBo(String name, String patientDocType, String patientDocNum, Date dateOfBirth, String year, String sex) {
        this.name = name;
        this.patientDocType = patientDocType;
        this.patientDocNum = patientDocNum;
        this.dateOfBirth = dateOfBirth;
        this.year = year;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientDocType() {
        return patientDocType;
    }

    public void setPatientDocType(String patientDocType) {
        this.patientDocType = patientDocType;
    }

    public String getPatientDocNum() {
        return patientDocNum;
    }

    public void setPatientDocNum(String patientDocNum) {
        this.patientDocNum = patientDocNum;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
