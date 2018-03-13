package com.joy.exception;

import com.joy.result.ConstantError;
import com.joy.result.data.ErrorResult;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by joybar on 2018/3/12.
 * http://blog.csdn.net/tianyaleixiaowu/article/details/70145251
 */
@RestController
public class BeforEnterControllerExceptionHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public Object error(HttpServletResponse resp, HttpServletRequest req) {
        // 错误处理逻辑
        ErrorResult  errorResult = new ErrorResult(ConstantError.BEFORE_ENTER_CONTROLLER_EXCEPTION.getErrorCode(), ConstantError.BEFORE_ENTER_CONTROLLER_EXCEPTION.getErrorMsg());
        return errorResult;
    }
}
