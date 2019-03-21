package com.harmonycloud.entity;

import javax.persistence.*;

/**
 * @date 2019/2/13
 */
@Entity
@Table(name = "contact_person")
public class ContactPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private String mobilePhoneAreaCode;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "other_phone_area_code")
    private String otherPhoneAreaCode;
    @Column(name = "other_phone")
    private String otherPhone;
    @Column(name = "email")
    private String email;
    @Column(name = "display_order")
    private Integer displayOrder;

    public ContactPerson() {
    }

    public ContactPerson(Integer patientId, String relationship,
                         String englishName, String chineseName, String mobilePhoneAreaCode,
                         String mobilePhone, String otherPhoneAreaCode, String otherPhone, String email,
                         Integer displayOrder) {
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

    public String getMobilePhoneAreaCode() {
        return mobilePhoneAreaCode;
    }

    public void setMobilePhoneAreaCode(String mobilePhoneAreaCode) {
        this.mobilePhoneAreaCode = mobilePhoneAreaCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOtherPhoneAreaCode() {
        return otherPhoneAreaCode;
    }

    public void setOtherPhoneAreaCode(String otherPhoneAreaCode) {
        this.otherPhoneAreaCode = otherPhoneAreaCode;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
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
