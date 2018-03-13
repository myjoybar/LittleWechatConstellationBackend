package com.joy.exception;

import com.joy.result.ConstantError;
import com.joy.result.data.ErrorResult;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by joybar on 2018/3/12.
 * http://blog.csdn.net/neosmith/article/details/51090509
 */
@ControllerAdvice
public class InEnterControllerExceptionHandler extends ResponseEntityExceptionHandler {



    /**
     * 处理@RequestParam错误, 即参数不足
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResult errorResult = new ErrorResult(ConstantError.IN_ENTER_CONTROLLER_EXCEPTION.getErrorCode(), ConstantError.IN_ENTER_CONTROLLER_EXCEPTION.getErrorMsg());
        errorResult.setMessage("Param error，do not match");
        return new ResponseEntity<>(errorResult, status);
    }

    /**
     * 处理500错误
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //log.error("got internal error : {}", ex);

        ErrorResult errorResult = new ErrorResult(ConstantError.IN_ENTER_CONTROLLER_EXCEPTION.getErrorCode(), ConstantError.IN_ENTER_CONTROLLER_EXCEPTION.getErrorMsg());
        // 请求方式不支持
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            errorResult.setMessage("request method do not support");
            return new ResponseEntity<>(errorResult, status);
        }
        return new ResponseEntity<>(errorResult, status);
    }


    /**
     * 处理参数类型转换失败
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //log.error("type mismatch");
        ErrorResult errorResult = new ErrorResult(ConstantError.IN_ENTER_CONTROLLER_EXCEPTION.getErrorCode(), ConstantError.IN_ENTER_CONTROLLER_EXCEPTION.getErrorMsg());
        errorResult.setMessage("type mismatch");
        return new ResponseEntity<> (errorResult, status);
    }
}
