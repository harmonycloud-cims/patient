package com.harmonycloud.controller;

import com.harmonycloud.result.CodeMsg;
import com.harmonycloud.result.Result;
import com.harmonycloud.service.PatientService;
import com.harmonycloud.bo.PatientAndPerson;
import com.harmonycloud.vo.CpVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
@Api(tags = "Patient")
@RestController
public class PatientController {

    @Resource
    private PatientService patientService;


    @ApiOperation(value = "register patient", httpMethod = "POST")
    @ApiImplicitParam(name = "CpVo", value = "patient entity", dataType = "CpVo")
    @PostMapping("/register")
    public Result register(@RequestBody CpVo cpVo) {
        return patientService.register(cpVo);
    }

    @ApiOperation(value = "get patient list", httpMethod = "POST")
    @ApiImplicitParam(name = "param", value = "{\"searchData\":\"1\"}", required = true, dataType = "Map")
    @PostMapping("/searchPatient")
    public Result getPatientList(@RequestBody Map<String,String> param) {
        String searchData = param.get("searchData");
        if (StringUtils.isEmpty(searchData)) {
            return Result.buildError(CodeMsg.PATIENT_NOT_EXIST);
        }
        return patientService.getPatientList(searchData);
    }

    @ApiOperation(value = "get patient by patientId ", httpMethod = "POST")
    @ApiImplicitParam(name = "patientId", value = "patientId", paramType = "query", dataType = "Integer")
    @GetMapping("/getPatient")
    public Result getPatient(@RequestParam("patientId") Integer patientId) {
        if (patientId <= 0) {
            return Result.buildError(CodeMsg.PATIENT_NOT_EXIST);
        }
        return patientService.getPatient(patientId);
    }

    @ApiOperation(value = "update patient", httpMethod = "POST")
    @ApiImplicitParam(name = "patientAndPerson", value = "patient and person", required = true, dataType = "PatientAndPerson")
    @PostMapping("/update")
    public Result updatePatient(@RequestBody PatientAndPerson patientAndPerson) {
        return patientService.updatePatient(patientAndPerson);
    }
}
