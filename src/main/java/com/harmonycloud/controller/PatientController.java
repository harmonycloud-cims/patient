package com.harmonycloud.controller;

import com.harmonycloud.dto.PatientAndContactDto;
import com.harmonycloud.entity.Patient;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "Patient")
@RestController
public class PatientController {

    @Resource
    private PatientService patientService;


    /**
     * register patient
     *
     * @param patientAndContactDto
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "register patient", httpMethod = "POST")
    @ApiImplicitParam(name = "patientAndContactDto", value = "patient and person", required = true, dataType = "PatientAndContactDto")
    @PostMapping("/register")
    public CimsResponseWrapper<List> register(@RequestBody PatientAndContactDto patientAndContactDto) throws Exception {
        if (patientAndContactDto == null) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAM_ERROR.getMessage(), null);
        }
        boolean success = patientService.register(patientAndContactDto);
        if (!success) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAM_ERROR.getMessage(), null);
        }
        return new CimsResponseWrapper<>(success, null, null);
    }

    /**
     * get patient by searchData
     *
     * @param searchData
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "get patient list", httpMethod = "GET")
    @ApiImplicitParam(name = "searchData", value = "searchData", required = true, dataType = "String")
    @GetMapping("/searchPatient")
    public CimsResponseWrapper<List> getPatientList(@RequestParam("searchData") String searchData) throws Exception {
        if (StringUtils.isEmpty(searchData)) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAM_ERROR.getMessage(), null);
        }
        List<PatientAndContactDto> patientAndContactDtoList = patientService.getPatientList(searchData);
        return new CimsResponseWrapper<>(true, null, patientAndContactDtoList);
    }

    /**
     * get patient by patientId
     *
     * @param patientId
     * @return
     */
    @ApiOperation(value = "get patient by patientId ", httpMethod = "GET")
    @ApiImplicitParam(name = "patientId", value = "patientId", paramType = "query", dataType = "Integer")
    @GetMapping("/getPatient")
    public CimsResponseWrapper<Patient> getPatient(@RequestParam("patientId") Integer patientId) throws Exception {
        if (patientId == null) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PATIENT_NOT_EXIST.getMessage(), null);
        }
        Patient patient = patientService.getPatient(patientId);
        return new CimsResponseWrapper<>(true, null, patient);
    }

    /**
     * update patient
     *
     * @param patientAndContactDto
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "update patient", httpMethod = "POST")
    @ApiImplicitParam(name = "patientAndContactDto", value = "patient and person", required = true, dataType = "PatientAndContactDto")
    @PostMapping("/update")
    public CimsResponseWrapper<List> updatePatient(@RequestBody PatientAndContactDto patientAndContactDto) throws Exception {
        if (patientAndContactDto == null) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAM_ERROR.getMessage(), null);
        }
        boolean success = patientService.updatePatient(patientAndContactDto);
        if (!success) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAM_ERROR.getMessage(), null);
        }
        return new CimsResponseWrapper<>(success, null, null);
    }
}
