package com.harmonycloud.vo;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;

import java.util.List;

public class CpVo {
    private Patient patient;
    private List<ContactPerson> contactPeopleList;

    public CpVo() {
    }

    public CpVo(Patient patient, List<ContactPerson> contactPeopleList) {
        this.patient = patient;
        this.contactPeopleList = contactPeopleList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<ContactPerson> getContactPeopleList() {
        return contactPeopleList;
    }

    public void setContactPeopleList(List<ContactPerson> contactPeopleList) {
        this.contactPeopleList = contactPeopleList;
    }
}
