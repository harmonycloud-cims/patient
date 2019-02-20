package com.harmonycloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Entity
@Table(name = "contact_person")
public class ContactPerson {
    @Id
    private Integer contactPersonId;
    @Column(name = "patient_id")
    private Integer patientId;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "english_name")
    private String englishName;
    @Column(name = "chinese_name")
    private String chineseName;
    @Column(name = "mobile_phone_area_code")
    private Integer mobilePhoneAreaCode;
    @Column(name = "mobile_phone")
    private Integer mobilePhone;
    @Column(name = "other_phone_area_code")
    private Integer otherPhoneAreaCode;
    @Column(name = "other_phone")
    private Integer otherPhone;
    @Column(name = "email")
    private String email;
    @Column(name = "display_order")
    private Integer displayOrder;

    public ContactPerson() {
    }

    public ContactPerson(Integer contactPersonId, Integer patientId, String relationship,
                         String englishName, String chineseName, Integer mobilePhoneAreaCode,
                         Integer mobilePhone, Integer otherPhoneAreaCode, Integer otherPhone, String email,
                         Integer displayOrder) {
        this.contactPersonId = contactPersonId;
        this.patientId = patientId;
        this.relationship = relationship;
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.mobilePhoneAreaCode = mobilePhoneAreaCode;
        this.mobilePhone = mobilePhone;
        this.otherPhoneAreaCode = otherPhoneAreaCode;
        this.otherPhone = otherPhone;
        this.email = email;
        this.displayOrder = displayOrder;
    }

    public Integer getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(Integer contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public Integer getMobilePhoneAreaCode() {
        return mobilePhoneAreaCode;
    }

    public void setMobilePhoneAreaCode(Integer mobilePhoneAreaCode) {
        this.mobilePhoneAreaCode = mobilePhoneAreaCode;
    }

    public Integer getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Integer mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getOtherPhoneAreaCode() {
        return otherPhoneAreaCode;
    }

    public void setOtherPhoneAreaCode(Integer otherPhoneAreaCode) {
        this.otherPhoneAreaCode = otherPhoneAreaCode;
    }

    public Integer getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(Integer otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
