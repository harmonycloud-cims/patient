package com.harmonycloud.vo;

public class ContactPersonVo {
    private String relationship;
    private String englishName;
    private String chineseName;
    private String mobilePhoneAreaCode;
    private String mobilePhone;
    private String otherPhoneAreaCode;
    private String otherPhone;
    private String email;
    private Integer displayOrder;

    public ContactPersonVo() {
    }

    public ContactPersonVo(String relationship, String englishName, String chineseName, String mobilePhoneAreaCode, String mobilePhone, String otherPhoneAreaCode, String otherPhone, String email, Integer displayOrder) {
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
