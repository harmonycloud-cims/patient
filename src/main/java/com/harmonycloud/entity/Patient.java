package com.harmonycloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private Integer patientId;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "document_number")
    private Integer documentNumber;
    @Column(name = "english_surname")
    private String englishSurname;
    @Column(name = "english_given_name")
    private String englishGivenName;
    @Column(name = "chinese_name")
    private String chineseName;
    @Column(name = "date_or_birth")
    private Date dateOrBirth;
    @Column(name = "sex")
    private String sex;
    @Column(name = "mobile_phone_area_code")
    private Integer mobilePhoneAreaCode;
    @Column(name = "mobile_phone")
    private Integer mobilePhone;
    @Column(name = "home_phone_area_code")
    private Integer homePhoneAreaCode;
    @Column(name = "home_phone")
    private Integer homePhone;
    @Column(name = "room")
    private Integer room;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "block")
    private String block;
    @Column(name = "building")
    private String building;
    @Column(name = "estate")
    private String estate;
    @Column(name = "street")
    private String street;
    @Column(name = "region")
    private String region;
    @Column(name = "district")
    private String district;

    public Patient() {
    }

    public Patient(Integer patientId, String documentType, Integer documentNumber, String englishSurname,
                   String englishGivenName, String chineseName, Date dateOrBirth, String sex,
                   Integer mobilePhoneAreaCode, Integer mobilePhone, Integer homePhoneAreaCode,
                   Integer homePhone, Integer room, Integer floor, String block, String building,
                   String estate, String street, String region, String district) {
        this.patientId = patientId;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.chineseName = chineseName;
        this.dateOrBirth = dateOrBirth;
        this.sex = sex;
        this.mobilePhoneAreaCode = mobilePhoneAreaCode;
        this.mobilePhone = mobilePhone;
        this.homePhoneAreaCode = homePhoneAreaCode;
        this.homePhone = homePhone;
        this.room = room;
        this.floor = floor;
        this.block = block;
        this.building = building;
        this.estate = estate;
        this.street = street;
        this.region = region;
        this.district = district;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
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

    public Date getDateOrBirth() {
        return dateOrBirth;
    }

    public void setDateOrBirth(Date dateOrBirth) {
        this.dateOrBirth = dateOrBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public Integer getHomePhoneAreaCode() {
        return homePhoneAreaCode;
    }

    public void setHomePhoneAreaCode(Integer homePhoneAreaCode) {
        this.homePhoneAreaCode = homePhoneAreaCode;
    }

    public Integer getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Integer homePhone) {
        this.homePhone = homePhone;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
