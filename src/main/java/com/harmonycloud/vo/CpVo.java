package com.harmonycloud.vo;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;

import java.util.List;

public class CpVo {
    private Patient patient;
    private List<ContactPerson> contactPeople;

    public CpVo() {
    }

    public CpVo(Patient patient, List<ContactPerson> contactPeople) {
        this.patient = patient;
        this.contactPeople = contactPeople;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<ContactPerson> getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(List<ContactPerson> contactPeople) {
        this.contactPeople = contactPeople;
    }
}
