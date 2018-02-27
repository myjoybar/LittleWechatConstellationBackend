package com.joy.controller;

import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.SuccessResult;
import com.joy.services.user.UserServiceImpl;
import com.joy.utils.SOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by joybar on 2018/2/27.
 */
@RestController
public class UserController {

    public static String TAG = "UserController";

    @Autowired
    private UserServiceImpl userService;

    // http://106.14.139.72:8221/constellation/say
    // http://localhost:8221/constellation/say
    @GetMapping(value = "/sayuser")
    public BaseResultInfo say() {
        return new SuccessResult("hello user");
    }

    //  http://localhost:8221/constellation/addUser?nickName=Tom&avatarUrl=http://test.com
    @PostMapping(value = "/addUser", produces = "application/json; charset=utf-8")
    public BaseResultInfo addUser(@RequestParam("nickName") String nickName,
                                  @RequestParam("avatarUrl") String avatarUrl) throws UnsupportedEncodingException {
        SOUtils.print("addUser");
        return userService.addUser(nickName, avatarUrl);
    }

}
