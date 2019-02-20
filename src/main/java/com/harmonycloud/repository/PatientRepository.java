package com.harmonycloud.repository;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


    List<Patient> findByPatientId(Integer num);

    List<Patient> findByMobilePhone(Integer num);

    List<Patient> findByEnglishGivenName(String str);

    List<Patient> findByEnglishSurname(String str);

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update Patient p set p.documentType = ?2, p.documentNumber = ?3, p.englishSurname = ?4, p.englishGivenName = ?5," +
            "p.chineseName = ?6, p.dateOrBirth = ?7, p.sex = ?8, p.mobilePhoneAreaCode = ?9, p.mobilePhone = ?10, " +
            "p.homePhoneAreaCode = ?11, p.homePhone = ?12, p.room = ?13, p.floor = ?14, p.block = ?15, p.building = ?16," +
            "p.estate = ?17, p.street = ?18, p.region = ?19, p.district = ?20 where p.patientId = ?1")
    int updateById(Integer patientId, String documentType, Integer documentNumber, String englishSurname,
                   String englishGivenName, String chineseName, Date dateOrBirth, String sex,
                   Integer mobilePhoneAreaCode, Integer mobilePhone, Integer homePhoneAreaCode,
                   Integer homePhone, Integer room, Integer floor, String block, String building,
                   String estate, String street, String region, String district);


}
