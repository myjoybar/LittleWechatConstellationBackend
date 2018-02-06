package com.joy.controller;

import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.SuccessResult;
import com.joy.services.constellation.ConstellationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joybar on 2018/2/6.
 */
@RestController
public class ConstellationController {

    public static String TAG = "ConstellationController";

    @Autowired
    private ConstellationServiceImpl constellationService;

    @GetMapping(value = "/say")
    public BaseResultInfo say() {
        return new SuccessResult( "hello");
    }

    //http://localhost:8221/constellation/test
    @GetMapping(value = "/test")
    public String test() {
        return constellationService.test();
    }


}
