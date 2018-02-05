package com.joy.dao.user;

import com.joy.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by joybar on 2018/2/5.
 */
public interface UserRepository extends JpaRepository<UserInfo,Long>,JpaSpecificationExecutor<UserInfo> {
}
