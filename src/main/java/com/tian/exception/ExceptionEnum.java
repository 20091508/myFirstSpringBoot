package com.tian.exception;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author tianxf9
 * @version 1.0
 * @Date Created in 2017年06月24日 19:27
 * @since 1.0
 */
public enum ExceptionEnum {
    SUCCESS(0,"成功"),
    SYS_FAIL(1,"失败"),
    XIAOXUE(100,"你可能在上小学"),
    ZHONGXUE(101,"你可能在上中学");
    private int code;
    private String msg;

    ExceptionEnum(int code,String msg) {

        this.code = code;
        this.msg = msg;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
