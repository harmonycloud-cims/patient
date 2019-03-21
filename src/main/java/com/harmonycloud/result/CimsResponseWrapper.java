package com.harmonycloud.result;

import io.swagger.annotations.ApiModelProperty;


/**
 * @date 2019/2/15
 */
public class CimsResponseWrapper<E> {
    @ApiModelProperty(required = true)
    private boolean success;

    @ApiModelProperty(notes = "only return when success=false")
    private String errorMessage;

    @ApiModelProperty(notes = "only return when success=true")
    private E data;

    public CimsResponseWrapper() {
        super();
    }

    public CimsResponseWrapper(boolean success, String errorMessage, E data) {
        super();
        this.success = success;
        this.errorMessage = errorMessage;
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public E getdata() {
        return data;
    }

    public void setdata(E data) {
        this.data = data;
    }


}
