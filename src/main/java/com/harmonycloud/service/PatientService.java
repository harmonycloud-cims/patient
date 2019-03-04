package com.harmonycloud.service;

import com.harmonycloud.bo.PatientBo;
import com.harmonycloud.entity.ContactPerson;
import com.harmonycloud.entity.Patient;
import com.harmonycloud.repository.PatientRepository;
import com.harmonycloud.result.CodeMsg;
import com.harmonycloud.result.Result;
import com.harmonycloud.vo.CpVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    @Resource
    private PatientRepository patientRepository;

    @Resource
    private ContactPersonService cpService;

    public Result register(CpVo CpVo) {
        Patient patient = CpVo.getPatient();
        List<ContactPerson> contactPersonList = CpVo.getContactPersonList();
        Result result = checkPatient(patient);
        if (result != null) {
            return result;
        }
        try {
            patientRepository.save(patient);
            cpService.register(contactPersonList,patient.getPatientId());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.REGISTER_FAIL);
        }
        return Result.buildSuccess(CodeMsg.REGISTER_SUCCESS);
    }

    public Result getPatient(Integer patientId) {
        DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        try {
            Patient patient = patientRepository.findByPatientId(patientId);
            String patientDocType = patient.getDocumentType();
            String patientDocNum = patient.getDocumentNumber();
            String patientName = patient.getEnglishGivenName()+","+patient.getEnglishSurname()+"("+patient.getChineseName()+")";
            String patientDob = patient.getDateOfBirth();
            Calendar cal = Calendar.getInstance();
            Integer year = cal.get(Calendar.YEAR);
            cal.setTime(sdf.parse(patientDob));
            Integer yearbirth = cal.get(Calendar.YEAR);
            Integer age= year-yearbirth;
            PatientBo patientBo = new PatientBo(patientName,patientDocType,patientDocNum,patientDob,age+"Y",patient.getSex());
            return Result.buildSuccess(patientBo);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.SERVICE_ERROR);
        }

    }

    public Result getPatientList(String searchData) {
        List<Patient> patientList = new ArrayList<Patient>();
        List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
        List<CpVo> cpVoList = new ArrayList<CpVo>();
        try {
            patientList = patientRepository.findBySearchContaining(searchData);
            for (int i = 0; i < patientList.size(); i++) {
                contactPersonList = cpService.getContactPerson(patientList.get(i).getPatientId());
                CpVo cpVo = new CpVo(patientList.get(i), contactPersonList);
                cpVoList.add(cpVo);
            }
            return Result.buildSuccess(cpVoList);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Result.buildError(CodeMsg.SERVICE_ERROR);
        }
    }


    public Result updatePatient(CpVo cpVo) {
        Patient patient = cpVo.getPatient();
        List<ContactPerson> contactPersonList = cpVo.getContactPersonList();
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
        if (patient.getDateOfBirth() == null) {
            return Result.buildError(CodeMsg.DATE_OR_BIRTH_EMPTY);
        }
        return null;
    }

}
