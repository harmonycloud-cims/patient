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


    Patient findByPatientId(Integer id);

    /**
     * 模糊查询
     * @param num
     * @return
     */
//    @Query(nativeQuery = true,value = "select * from \"patient\" where  to_char(\"mobile_phone\") like '%'||?1||'%' or to_char(\"document_number\") like '%'||?1||'%' or \"english_given_name\" like '%'||?1||'%' or \"english_surname\" like '%'||?1||'%'")
    List<Patient> findBySearchContaining(String num);

}
