package com.joy.controller;

import com.joy.entity.UserInformation;
import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.SuccessResult;
import com.joy.services.user.UserServiceImpl;
import com.joy.utils.SOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/findalluser", method = {RequestMethod.GET})
    public BaseResultInfo findAllUserInfo(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "role", defaultValue = "3") Integer role,
            @RequestParam(value = "sortDirection", defaultValue = "0") Integer sortDirection
    ) {

        Page<UserInformation> datas = userService.findAllUserInfo(pageNumber, pageSize, role, sortDirection);
        SuccessResult resultInfo = new SuccessResult(datas);
        return resultInfo;
    }


}
