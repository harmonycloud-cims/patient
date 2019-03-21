package com.harmonycloud.enums;


public enum ErrorMsgEnum {

    SERVICE_ERROR("Internal service error"),
    DOCUMENT_TYPE_EMPTY("document type is empty"),
    ENGLISH_SURNAME__EMPTY("english surname is empty"),
    DOCUMENT_NUMBER_EMPTY("document number is lack"),
    ENGLISH_GIVEN_NAME_EMPTY("english given name is lack"),
    DATE_OR_BIRTH_EMPTY("date or birth is lack"),
    PATIENT_NOT_EXIST("patient is not exist"),
    REGISTER_FAIL("register is failed"),
    UPDATE_FAIL("update is failed"),
    PARAM_ERROR("param error"),
    QUERY_ERROR("query error"),
    SAVE_ERROR("save error");

    private String message;

    ErrorMsgEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
