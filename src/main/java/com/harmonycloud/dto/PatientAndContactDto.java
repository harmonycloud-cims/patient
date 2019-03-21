package com.harmonycloud.dto;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;

import java.util.List;

public class PatientAndContactDto {
    private Patient patient;
    private List<ContactPerson> contactPersonList;

    public PatientAndContactDto() {
    }

    public PatientAndContactDto(Patient patient, List<ContactPerson> contactPersonList) {
        this.patient = patient;
        this.contactPersonList = contactPersonList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<ContactPerson> getContactPersonList() {
        return contactPersonList;
    }

    public void setContactPersonList(List<ContactPerson> contactPersonList) {
        this.contactPersonList = contactPersonList;
    }
}
