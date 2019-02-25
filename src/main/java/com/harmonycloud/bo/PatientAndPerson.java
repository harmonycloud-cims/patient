package com.harmonycloud.bo;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;

import java.util.List;

/**
 * @author qidong
 * @date 2019/2/15
 */
public class PatientAndPerson {
    private Patient patient;
    private List<ContactPerson> contactPersonList;

    public PatientAndPerson() {
    }

    public PatientAndPerson(Patient patient, List<ContactPerson> contactPersonList) {
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
