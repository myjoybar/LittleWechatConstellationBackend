package com.joy.exception;

import com.joy.result.ConstantError;
import com.joy.result.data.ErrorResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by joybar on 2018/3/12.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ConstellationException.class)
    @ResponseBody
    public ErrorResult jsonErrorHandler(HttpServletRequest req, ConstellationException e) throws Exception {
        ErrorResult  errorResult = new ErrorResult(ConstantError.GLOBAL_EXCEPTION.getErrorCode(), ConstantError.GLOBAL_EXCEPTION.getErrorMsg()+e.getMessage());
        return errorResult;
    }
}
