package com.harmonycloud.bo;

import javax.persistence.Column;
import java.util.Date;

public class PatientBo {
    private String documentType;
    private String documentNumber;
    private String englishSurname;
    private String englishGivenName;
    private String chineseName;
    private Date dateOfBirth;
    private String sex;

    public PatientBo() {
    }

    public PatientBo(String documentType, String documentNumber, String englishSurname,
                     String englishGivenName, String chineseName, Date dateOfBirth, String sex) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.chineseName = chineseName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEnglishSurname() {
        return englishSurname;
    }

    public void setEnglishSurname(String englishSurname) {
        this.englishSurname = englishSurname;
    }

    public String getEnglishGivenName() {
        return englishGivenName;
    }

    public void setEnglishGivenName(String englishGivenName) {
        this.englishGivenName = englishGivenName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
