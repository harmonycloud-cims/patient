package com.harmonycloud.result;

/**
 * @author qidong
 * @date 2019/2/15
 */
public class CodeMsg {
    private String msg;

    public CodeMsg( String msg) {
        this.msg = msg;
    }

    /**
     * code:20xxx patient service
     */
    public static CodeMsg REGISTER_SUCCESS = new CodeMsg("register is success");
    public static CodeMsg DOCUMENT_TYPE_EMPTY = new CodeMsg( "document type is empty");
    public static CodeMsg ENGLISH_SURNAME__EMPTY = new CodeMsg("english surname is empty");
    public static CodeMsg DOCUMENT_NUMBER_EMPTY = new CodeMsg("document number is lack");
    public static CodeMsg ENGLISH_GIVEN_NAME_EMPTY = new CodeMsg( "english given name is lack");
    public static CodeMsg DATE_OR_BIRTH_EMPTY = new CodeMsg( "date or birth is lack");
    public static CodeMsg PATIENT_NOT_EXIST = new CodeMsg( "patient is not exist");
    public static CodeMsg REGISTER_FAIL = new CodeMsg("register is failed");
    public static CodeMsg UPDATE_SUCCESS = new CodeMsg("update is success");
    public static CodeMsg UPDATE_FAIL = new CodeMsg( "update is failed");
    public static CodeMsg SERVICE_ERROR=new CodeMsg("Service error");



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
