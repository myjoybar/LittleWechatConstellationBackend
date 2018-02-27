package com.joy.services.user;

import com.joy.dao.constellation.UserRepository;
import com.joy.entity.UserInfo;
import com.joy.result.ConstantError;
import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.ErrorResult;
import com.joy.result.data.SuccessResult;
import com.joy.utils.SOUtils;
import com.joy.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by joybar on 2018/2/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public BaseResultInfo addUser(String nickName, String avatarUrl) {
        BaseResultInfo baseResultInfo = null;
        ErrorResult errorResult = null;
        if (StringUtils.isEmpty(nickName)) {
            errorResult = new ErrorResult(ConstantError.ERROR_NICKNAME_BROADCAST_MSG_EMPTY.getErrorCode(), ConstantError.ERROR_NICKNAME_BROADCAST_MSG_EMPTY.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        }
        if (StringUtils.isEmpty(avatarUrl)) {
            errorResult = new ErrorResult(ConstantError.ERROR_AVATAR_URL_BROADCAST_MSG_EMPTY.getErrorCode(), ConstantError.ERROR_AVATAR_URL_BROADCAST_MSG_EMPTY.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        }
        List<UserInfo> listUser = this.findUserInfoByNickNameAndAvatarUrl(nickName, avatarUrl);
        if (null == listUser || listUser.size() == 0) {
            SOUtils.print("this user has not been saved");
            UserInfo user = new UserInfo(nickName, avatarUrl);
            UserInfo userResult = userRepository.save(user);
            if (null == userResult) {
                errorResult = new ErrorResult(ConstantError.ERROR_USER_INFO_SAVE_OCCURS_ERROR.getErrorCode(), ConstantError.ERROR_USER_INFO_SAVE_OCCURS_ERROR.getErrorMsg());
                baseResultInfo = new ErrorResult(errorResult);
                return baseResultInfo;
            } else {
                baseResultInfo = new SuccessResult(userResult);
                return baseResultInfo;
            }
        } else {
            SOUtils.print("this user has saved");
            baseResultInfo = new SuccessResult(new UserInfo(nickName, avatarUrl));
            return baseResultInfo;
        }

    }

    @Override
    public List<UserInfo> findUserInfoByNickNameAndAvatarUrl(String nickName, String avatarUrl) {
        return userRepository.findByNickNameAndAvatarUrl(nickName, avatarUrl);

    }


}
