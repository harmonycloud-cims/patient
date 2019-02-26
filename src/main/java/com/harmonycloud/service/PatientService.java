package com.harmonycloud.service;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;
import com.harmonycloud.repository.PatientRepository;
import com.harmonycloud.result.CodeMsg;
import com.harmonycloud.result.Result;
import com.harmonycloud.bo.PatientAndPerson;
import com.harmonycloud.vo.ContactPersonVo;
import com.harmonycloud.vo.CpVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    @Resource
    private PatientRepository patientRepository;

    @Resource
    private ContactPersonService cpService;

    public Result register(CpVo CpVo) {
        Patient patient = CpVo.getPatient();
        List<ContactPersonVo> contactPersonVoList = CpVo.getContactPersonVoList();
        List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
        Result result = checkPatient(patient);
        if (result != null) {
            return result;
        }
        try {
            patientRepository.save(patient);
            if (contactPersonVoList.size() > 0) {
                for (int i = 0; i < contactPersonVoList.size(); i++) {
                    ContactPerson contactPerson = new ContactPerson(patient.getPatientId(), contactPersonVoList.get(i).getRelationship(),
                            contactPersonVoList.get(i).getEnglishName(), contactPersonVoList.get(i).getChineseName(),
                            contactPersonVoList.get(i).getMobilePhoneAreaCode(), contactPersonVoList.get(i).getMobilePhone(),
                            contactPersonVoList.get(i).getOtherPhoneAreaCode(), contactPersonVoList.get(i).getOtherPhone(),
                            contactPersonVoList.get(i).getEmail(), contactPersonVoList.get(i).getDisplayOrder());
                    contactPersonList.add(contactPerson);
                }
                cpService.register(contactPersonList);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.REGISTER_FAIL);
        }
        return Result.buildSuccess(CodeMsg.REGISTER_SUCCESS);
    }

    public Result getPatient(Integer patientId) {
        List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
        try {
            Patient patient = patientRepository.findByPatientId(patientId);
            contactPersonList = cpService.getContactPerson(patientId);
            PatientAndPerson patientAndPerson = new PatientAndPerson(patient, contactPersonList);
            return Result.buildSuccess(patientAndPerson);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.SERVICE_ERROR);
        }
    }

    public Result getPatientList(String searchData) {
        List<Patient> patientsList = new ArrayList<Patient>();
        List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
        List<PatientAndPerson> patientAndPersonList = new ArrayList<PatientAndPerson>();
        try {
            patientsList = patientRepository.findBySearchContaining(searchData);
            for (int i = 0; i < patientsList.size(); i++) {
                contactPersonList = cpService.getContactPerson(patientsList.get(i).getPatientId());
                PatientAndPerson patientAndPerson = new PatientAndPerson(patientsList.get(i), contactPersonList);
                patientAndPersonList.add(patientAndPerson);
            }
            return Result.buildSuccess(patientAndPersonList);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.SERVICE_ERROR);
        }
    }


    public Result updatePatient(PatientAndPerson patientAndPerson) {
        Patient patient = patientAndPerson.getPatient();
        List<ContactPerson> contactPersonList = patientAndPerson.getContactPersonList();
        try {
            patientRepository.save(patient);
            cpService.updatePatient(contactPersonList);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.UPDATE_FAIL);
        }
        return Result.buildSuccess(CodeMsg.UPDATE_SUCCESS);
    }

    /**
     * 判断Patient是否合法
     *
     * @param patient
     * @return
     */
    private Result checkPatient(Patient patient) {
        if (patient.getPatientId() == null) {
            return Result.buildError(CodeMsg.PATIENT_NOT_EXIST);
        }
        if (StringUtils.isEmpty(patient.getDocumentType())) {
            return Result.buildError(CodeMsg.DOCUMENT_TYPE_EMPTY);
        }
        if (StringUtils.isEmpty(patient.getEnglishSurname())) {
            return Result.buildError(CodeMsg.ENGLISH_SURNAME__EMPTY);
        }
        if (patient.getDocumentNumber() == null) {
            return Result.buildError(CodeMsg.DOCUMENT_NUMBER_EMPTY);
        }
        if (StringUtils.isEmpty(patient.getEnglishGivenName())) {
            return Result.buildError(CodeMsg.ENGLISH_GIVEN_NAME_EMPTY);
        }
        if (patient.getDateOrBirth() == null) {
            return Result.buildError(CodeMsg.DATE_OR_BIRTH_EMPTY);
        }
        return null;
    }

}
