package com.harmonycloud.service;

import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;
import com.harmonycloud.repository.PatientRepository;
import com.harmonycloud.result.CodeMsg;
import com.harmonycloud.result.Result;
import com.harmonycloud.dto.PatientAndPerson;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    @Resource
    private PatientRepository patientRepository;

    @Resource
    private ContactPersonService cpService;

    public Result register(PatientAndPerson patientAndPerson){
        Patient patient = patientAndPerson.getPatient();
        List<ContactPerson> contactPersonList = patientAndPerson.getContactPersonList();
        Result result = checkPatient(patient);
        if (result != null) {
            return result;
        }
        try {
            patientRepository.save(patient);
            cpService.register(contactPersonList);
        }catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.REGISTER_FAIL);
        }
        return Result.buildSuccess(CodeMsg.REGISTER_SUCCESS);


    }


    public Result getPatient(String searchData) {
        List<Patient> patientsList = null;
        List<Patient> patientListTmp = null;
        PatientAndPerson patientAndPerson = new PatientAndPerson();

        //若传入的参数是数字，则根据patient id和手机号查询
        try {
            Integer searchDataInt = Integer.valueOf(searchData);
            patientsList = patientRepository.findByPatientId(searchDataInt);
            patientListTmp = patientRepository.findByMobilePhone(searchDataInt);
            if (patientListTmp.size() != 0) {
                patientsList.addAll(patientListTmp);
            }

        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        //根据名字查询
        if (patientsList == null || patientsList.size() == 0) {
            try {
                patientsList = patientRepository.findByEnglishGivenName(searchData);
                patientListTmp = patientRepository.findByEnglishSurname(searchData);
                if (patientListTmp.size() != 0) {
                    patientsList.addAll(patientListTmp);
                }
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }

        //patient查询出来只有一条，则返回跟病患相关的联系人
        if (patientsList.size() == 1) {
            List<ContactPerson> contactPersonList = cpService.getContactPerson(patientsList.get(0).getPatientId());
            try {
                patientAndPerson.setPatient(patientsList.get(0));
                patientAndPerson.setContactPersonList(contactPersonList);
                return Result.buildSuccess(patientAndPerson);
            } catch(Exception e) {
                logger.info(e.getMessage());
            }
        }
        if (patientsList.size() == 0) {
            return Result.buildError(CodeMsg.PATIENT_NOT_EXIST);
        }
        return Result.buildSuccess(patientsList);
    }


    public Result updatePatient(PatientAndPerson patientAndPerson) {
        Patient patient = patientAndPerson.getPatient();
        List<ContactPerson> contactPersonList = patientAndPerson.getContactPersonList();
        Result result = checkPatient(patient);
        if (result != null) {
            return result;
        }
        try {
            patientRepository.updateById(patient.getPatientId(),patient.getDocumentType(),patient.getDocumentNumber(),
                    patient.getEnglishSurname(),patient.getEnglishGivenName(),patient.getChineseName(),patient.getDateOrBirth(),
                    patient.getSex(),patient.getMobilePhoneAreaCode(),patient.getMobilePhone(),patient.getHomePhoneAreaCode(),
                    patient.getHomePhone(),patient.getRoom(),patient.getFloor(),patient.getBlock(),patient.getBuilding(),
                    patient.getEstate(),patient.getStreet(),patient.getRegion(),patient.getDistrict());
            cpService.updatePatient(contactPersonList);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.UPDATE_FAIL);
        }
        return Result.buildSuccess(CodeMsg.UPDATE_SUCCESS);
    }

    /**
     * 判断Patient是否合法
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
