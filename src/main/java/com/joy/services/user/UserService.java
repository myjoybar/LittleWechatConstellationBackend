package com.joy.services.user;

import com.joy.entity.UserInfo;
import com.joy.result.data.BaseResultInfo;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface UserService {

    BaseResultInfo addUser(String nickName, String avatarUrl);
    List<UserInfo> findUserInfoByNickNameAndAvatarUrl(String nickName, String avatarUrl);
}
