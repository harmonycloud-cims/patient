package com.harmonycloud.service;

import com.harmonycloud.dto.PatientAndContactDto;
import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.PatientException;
import com.harmonycloud.repository.PatientRepository;
import com.harmonycloud.result.CimsResponseWrapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    @Resource
    private PatientRepository patientRepository;

    @Resource
    private ContactPersonService cpService;

    /**
     * register patient
     *
     * @param patientAndContactDto
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean register(PatientAndContactDto patientAndContactDto) throws Exception {
        Patient patient = patientAndContactDto.getPatient();
        List<ContactPerson> contactPersonList = patientAndContactDto.getContactPersonList();
        if (!checkPatient(patient)) {
            return false;
        }
        patientRepository.save(patient);
        cpService.register(contactPersonList, patient.getPatientId());
        return true;
    }

    /**
     * get patient some information by patient id
     *
     * @param patientId
     * @return
     * @throws Exception
     */
    public Patient getPatient(Integer patientId) throws Exception {
        Patient patient = patientRepository.findByPatientId(patientId);
        return patient;
    }

    /**
     * get patient list by search data
     *
     * @param searchData
     * @return
     * @throws Exception
     */
    public List<PatientAndContactDto> getPatientList(String searchData) throws Exception {
        List<Patient> patientList = new ArrayList<>();
        List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
        List<PatientAndContactDto> patientAndContactDtoList = new ArrayList<PatientAndContactDto>();

        patientList = patientRepository.findBySearchContaining(searchData);
        for (int i = 0; i < patientList.size(); i++) {
            contactPersonList = cpService.getContactPerson(patientList.get(i).getPatientId());
            PatientAndContactDto patientAndContactDto = new PatientAndContactDto(patientList.get(i), contactPersonList);
            patientAndContactDtoList.add(patientAndContactDto);
        }
        return patientAndContactDtoList;
    }


    /**
     * update patient
     *
     * @param patientAndContactDto
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePatient(PatientAndContactDto patientAndContactDto) throws Exception {
        Patient patient = patientAndContactDto.getPatient();
        List<ContactPerson> contactPersonList = patientAndContactDto.getContactPersonList();
        boolean result = checkPatient(patient);
        if (!result) {
            return result;
        }
        patientRepository.save(patient);
        cpService.updatePatient(contactPersonList);
        return result;
    }

    /**
     * check Patient paramter is corrent
     *
     * @param patient
     * @return
     */
    private boolean checkPatient(Patient patient) {
        if (StringUtils.isEmpty(patient.getDocumentType())) {
            return false;
        }
        if (StringUtils.isEmpty(patient.getEnglishSurname())) {
            return false;
        }
        if (patient.getDocumentNumber() == null) {
            return false;
        }
        if (StringUtils.isEmpty(patient.getEnglishGivenName())) {
            return false;
        }
        if (patient.getDateOfBirth() == null) {
            return false;
        }
        return true;
    }

}
