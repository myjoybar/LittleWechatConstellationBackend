package com.joy.services.user;

import com.joy.constant.Constant;
import com.joy.dao.constellation.UserRepository;
import com.joy.entity.ConstellationBroadcast;
import com.joy.entity.UserInfo;
import com.joy.entity.enumconfig.UserRoleConfig;
import com.joy.result.ConstantError;
import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.ErrorResult;
import com.joy.result.data.SuccessResult;
import com.joy.utils.SOUtils;
import com.joy.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
            UserInfo userInfo = new UserInfo(nickName, avatarUrl);
            baseResultInfo = new SuccessResult(userInfo);
            return baseResultInfo;
        }

    }

    @Override
    public List<UserInfo> findUserInfoByNickNameAndAvatarUrl(String nickName, String avatarUrl) {
        return userRepository.findByNickNameAndAvatarUrl(nickName, avatarUrl);

    }

    @Override
    public Page<UserInfo> findAllUserInfo(Integer pageNumber, Integer pageSize, final Integer role, int sortDirection) {
        Pageable pageable = null;
        if (sortDirection == Constant.ARTICLE_SORT_DIRECTION_DESC) {
            pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.DESC, "id");
        } else {
            pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "id");
        }
        Page<UserInfo> bookPage = userRepository.findAll(new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(role!=UserRoleConfig.AllUser.getRoleCode()){
                    list.add(criteriaBuilder.equal(root.get("role").as(String.class), role));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageable);
        return bookPage;
    }

    @Override
    public BaseResultInfo deleteUserInfoById(Long id) {
        try {
            userRepository.delete(id);
            return new SuccessResult("");
        } catch (Exception e) {
            SOUtils.print("deleteUserInfoById error:" + e.getMessage());
        }
        return new ErrorResult("delete Success");
    }


}
