package com.joy.exception;

import com.joy.result.data.ErrorResult;

/**
 * Created by joybar on 2018/3/12.
 */
public class ConstellationException extends Exception {

    ErrorResult errorResult;

    public ConstellationException(String message) {
        super(message);
    }
    public ConstellationException(ErrorResult errorResult) {
        super(errorResult.getMessage());
    }

}
