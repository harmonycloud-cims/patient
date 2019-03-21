package com.harmonycloud.repository;

import com.harmonycloud.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2019/2/15
 */
@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {
    List<ContactPerson> findByPatientId(Integer num);

}
