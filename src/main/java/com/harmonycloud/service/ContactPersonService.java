package com.harmonycloud.service;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.repository.ContactPersonRepository;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContactPersonService {

    private static final Logger logger = LoggerFactory.getLogger(ContactPersonService.class);

    @Resource
    private ContactPersonRepository cpRepository;

    /**
     * register patient
     *
     * @param contactPersonList
     * @param patientId
     * @return
     * @throws Exception
     */
    public boolean register(List<ContactPerson> contactPersonList, Integer patientId) throws Exception {
        if (CollectionUtils.isNotEmpty(contactPersonList)) {
            for (int i = 0; i < contactPersonList.size(); i++) {
                contactPersonList.get(i).setPatientId(patientId);
            }
            cpRepository.saveAll(contactPersonList);
        }
        return true;
    }

    /**
     * get patient contact person
     *
     * @param num
     * @return
     * @throws Exception
     */
    public List<ContactPerson> getContactPerson(Integer num) throws Exception {
        List<ContactPerson> contactPersonList = cpRepository.findByPatientId(num);
        return contactPersonList;
    }

    /**
     * update patient
     *
     * @param contactPersonList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String updatePatient(List<ContactPerson> contactPersonList) {
        if (CollectionUtils.isNotEmpty(contactPersonList)) {
            cpRepository.saveAll(contactPersonList);
        }
        return null;
    }
}
