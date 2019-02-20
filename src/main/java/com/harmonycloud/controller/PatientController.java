package com.harmonycloud.controller;

import com.harmonycloud.result.CodeMsg;
import com.harmonycloud.result.Result;
import com.harmonycloud.service.PatientService;
import com.harmonycloud.dto.PatientAndPerson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
@Api(value = "病患controller", tags = {"病患操作接口"})
@RestController
public class PatientController {

    @Resource
    private PatientService patientService;


    @ApiOperation(value = "注册病患")
    @ApiImplicitParam(name = "patientAndPerson", value = "病患资料的实体类", required = true, dataType = "PatientAndPerson")
    @PostMapping("/register")
    public Result register(@ApiParam @RequestBody PatientAndPerson patientAndPerson) {
        return patientService.register(patientAndPerson);
    }

    @ApiOperation(value = "获取病患资料")
    @ApiImplicitParam(name = "param", value = "获取病患资料的参数", required = true, dataType = "Map")
    @PostMapping("/patient")
    public Result getPatient(@RequestBody Map<String,String> param) {
        String searchData = param.get("searchData");
        if (StringUtils.isEmpty(searchData)) {
            return Result.buildError(CodeMsg.PATIENT_NOT_EXIST);
        }
        return patientService.getPatient(searchData);
    }

    @ApiOperation(value = "更新病患资料")
    @ApiImplicitParam(name = "patientAndPerson", value = "病患资料的实体类", required = true, dataType = "PatientAndPerson")
    @PostMapping("/update")
    public Result updatePatient(@RequestBody PatientAndPerson patientAndPerson) {
        return patientService.updatePatient(patientAndPerson);
    }
}
