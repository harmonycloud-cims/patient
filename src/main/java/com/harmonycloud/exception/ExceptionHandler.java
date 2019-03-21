package com.harmonycloud.exception;

import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @date 2019/3/12
 */

@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    HttpServletRequest request;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public CimsResponseWrapper handler(Throwable e) {
        String msg = LogUtil.getRequest(request);

        logger.error(msg + ", information='" + e.getMessage() + '\'');
        if (e instanceof PatientException) {
            return new CimsResponseWrapper<>(false, e.getMessage(), null);
        }

        return new CimsResponseWrapper<>(false, ErrorMsgEnum.SERVICE_ERROR.getMessage(), null);

    }

}
