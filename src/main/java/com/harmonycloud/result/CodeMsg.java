package com.harmonycloud.result;

/**
 * @author qidong
 * @date 2019/2/15
 */
public class CodeMsg {
    private int code;
    private String msg;

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * code:20xxx patient service
     */
    public static CodeMsg REGISTER_SUCCESS = new CodeMsg(20200, "register is success");
    public static CodeMsg DOCUMENT_TYPE_EMPTY = new CodeMsg(20201, "document type is empty");
    public static CodeMsg ENGLISH_SURNAME__EMPTY = new CodeMsg(20202, "english surname is empty");
    public static CodeMsg DOCUMENT_NUMBER_EMPTY = new CodeMsg(20203, "document number is lack");
    public static CodeMsg ENGLISH_GIVEN_NAME_EMPTY = new CodeMsg(20204, "english given name is lack");
    public static CodeMsg DATE_OR_BIRTH_EMPTY = new CodeMsg(20205, "date or birth is lack");
    public static CodeMsg PATIENT_NOT_EXIST = new CodeMsg(20206, "patient is not exist");
    public static CodeMsg REGISTER_FAIL = new CodeMsg(20207, "register is failed");
    public static CodeMsg UPDATE_SUCCESS = new CodeMsg(20208, "update is success");
    public static CodeMsg UPDATE_FAIL = new CodeMsg(20209, "update is failed");


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
