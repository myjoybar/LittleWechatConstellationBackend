package com.joy.result.data;

/**
 * Created by joybar on 2017/4/26.
 */
public class ErrorResult<T extends Object> extends BaseResultInfo {

    public static final Integer ERROR_CODE = 0;
    public static final String ERROR_MSG = "error";

    public ErrorResult(Integer errorCode,String errorMsg) {
        this.setCode(errorCode);
        this.setMessage(errorMsg);
        this.setResponseTime(System.currentTimeMillis());
    }

    public ErrorResult(T resultData) {
        this.setCode(ERROR_CODE);
        this.setMessage(ERROR_MSG);
        this.setResponseTime(System.currentTimeMillis());
        this.setData(resultData);
    }

    public ErrorResult(T resultData,String errorMsg) {
        this.setCode(ERROR_CODE);
        this.setMessage(errorMsg);
        this.setResponseTime(System.currentTimeMillis());
        this.setData(resultData);
    }
}
