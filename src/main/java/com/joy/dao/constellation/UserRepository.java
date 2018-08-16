package com.joy.dao.constellation;

import com.joy.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface UserRepository extends JpaRepository<UserInformation,Long>,JpaSpecificationExecutor<UserInformation> {

    List<UserInformation> findByNickNameAndAvatarUrl(String nickName, String avatarUrl);
}
