package com.harmonycloud.service;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.repository.ContactPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qidong
 * @date 2019/2/15
 */
@Service
public class ContactPersonService {

    private static final Logger logger = LoggerFactory.getLogger(ContactPerson.class);

    @Resource
    ContactPersonRepository cpRepository;

    @Transactional(rollbackFor = Exception.class)
    public String register(List<ContactPerson> contactPersonList) {
        if (contactPersonList != null) {
            for (int i = 0; i < contactPersonList.size(); i++) {
                cpRepository.save(contactPersonList.get(i));
            }
        }
        return null;
    }

    public List<ContactPerson> getContactPerson(Integer num) {
        List<ContactPerson> ContactPersonList = new ArrayList<ContactPerson>();
        try {
            ContactPersonList = cpRepository.findByPatientId(num);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return ContactPersonList;
    }

    @Transactional(rollbackFor = Exception.class)
    public String updatePatient(List<ContactPerson> contactPersonList) {
        if (contactPersonList != null) {
            for (int i = 0; i < contactPersonList.size(); i++) {
                cpRepository.save(contactPersonList.get(i));
            }
        }
        return null;
    }
}
