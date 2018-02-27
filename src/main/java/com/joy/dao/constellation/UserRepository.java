package com.joy.dao.constellation;

import com.joy.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface UserRepository extends JpaRepository<UserInfo,Long>,JpaSpecificationExecutor<UserInfo> {

    List<UserInfo> findByNickNameAndAvatarUrl(String nickName,String avatarUrl);
}
