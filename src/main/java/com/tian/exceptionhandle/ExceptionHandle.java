package com.tian.exceptionhandle;

import com.tian.domain.Result;
import com.tian.exception.ExceptionEnum;
import com.tian.exception.GirlException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @Date Created in 2017年06月24日 19:21
 * @since 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        Result result = new Result();
        if(e instanceof GirlException) {
            result.setMsg(e.getMessage());
            result.setCode(((GirlException) e).getCode());
        }else {
            result.setCode(ExceptionEnum.SYS_FAIL.getCode());
            result.setMsg(ExceptionEnum.SYS_FAIL.getMsg());

        }
        return  result;
    }
}
