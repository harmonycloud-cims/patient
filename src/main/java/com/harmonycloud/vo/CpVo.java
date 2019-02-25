package com.harmonycloud.vo;

import com.harmonycloud.entity.Patient;

import java.util.List;

public class CpVo {
   private Patient patient;
    private List<ContactPersonVo> contactPersonVoList;

    public CpVo() {
    }

    public CpVo(Patient patient, List<ContactPersonVo> contactPersonVoList) {
        this.patient = patient;
        this.contactPersonVoList = contactPersonVoList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<ContactPersonVo> getContactPersonVoList() {
        return contactPersonVoList;
    }

    public void setContactPersonVoList(List<ContactPersonVo> contactPersonVoList) {
        this.contactPersonVoList = contactPersonVoList;
    }
}
