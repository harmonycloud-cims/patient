package com.harmonycloud.repository;

import com.harmonycloud.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qidong
 * @date 2019/2/15
 */
@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson,Integer> {
    List<ContactPerson> findByPatientId(Integer num);

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update ContactPerson cp set cp.relationship = ?2, cp.englishName = ?3, cp.chineseName = ?4," +
            "cp.mobilePhoneAreaCode = ?5, cp.mobilePhone = ?6, cp.otherPhoneAreaCode = ?7, cp.otherPhone = ?8," +
            "cp.email = ?9, cp.displayOrder = ?10 where cp.patientId = ?1")
    int updateByid(Integer patientId, String relationship,
                   String englishName, String chineseName, String mobilePhoneAreaCode,
                   String mobilePhone, String otherPhoneAreaCode, String otherPhone, String email,
                   Integer displayOrder);
}
