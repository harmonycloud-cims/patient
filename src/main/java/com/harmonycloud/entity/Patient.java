package com.harmonycloud.entity;

import javax.persistence.*;
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
    private String documentNumber;
    @Column(name = "english_surname")
    private String englishSurname;
    @Column(name = "english_given_name")
    private String englishGivenName;
    @Column(name = "chinese_name")
    private String chineseName;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "sex")
    private String sex;
    @Column(name = "mobile_phone_area_code")
    private String mobilePhoneAreaCode;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "home_phone_area_code")
    private String homePhoneAreaCode;
    @Column(name = "home_phone")
    private String homePhone;
    @Column(name = "room")
    private String room;
    @Column(name = "floor")
    private String floor;
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
    @Column(name = "search")
    private String search;

    public Patient() {
    }

    public Patient(String documentType, String documentNumber, String englishSurname, String englishGivenName, String chineseName, String dateOfBirth, String sex, String mobilePhoneAreaCode, String mobilePhone, String homePhoneAreaCode, String homePhone, String room, String floor, String block, String building, String estate, String street, String region, String district,String search) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.englishSurname = englishSurname;
        this.englishGivenName = englishGivenName;
        this.chineseName = chineseName;
        this.dateOfBirth=dateOfBirth;
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
        this.search=search;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getHomePhoneAreaCode() {
        return homePhoneAreaCode;
    }

    public void setHomePhoneAreaCode(String homePhoneAreaCode) {
        this.homePhoneAreaCode = homePhoneAreaCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
