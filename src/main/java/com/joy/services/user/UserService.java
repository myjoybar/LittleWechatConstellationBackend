package com.joy.services.user;

import com.joy.entity.UserInformation;
import com.joy.result.data.BaseResultInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface UserService {

    BaseResultInfo addUser(String nickName, String avatarUrl);
    List<UserInformation> findUserInfoByNickNameAndAvatarUrl(String nickName, String avatarUrl);
    Page<UserInformation> findAllUserInfo(Integer pageNumber, Integer pageSize, final Integer role, int sortDirection);
    BaseResultInfo deleteUserInfoById(Long id);

}
