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
 * @Date Created in 2017年06月24日 19:26
 * @since 1.0
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
