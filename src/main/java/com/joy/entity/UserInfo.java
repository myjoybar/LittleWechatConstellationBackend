package com.joy.entity;

import com.joy.entity.enumconfig.UserGenderConfig;
import com.joy.entity.enumconfig.UserRoleConfig;

import javax.persistence.Entity;

/**
 * Created by joybar on 2017/5/15.
 */
@Entity
public class UserInfo extends BaseData {

    private String userName = "";
    private String password = "";
    private int sex = UserGenderConfig.UNKNOWN.getGenderCode();
    private int role = UserRoleConfig.commonUser.getRoleCode();
    private long birthDate = 0;

    private String nickName = "";
    private String avatarUrl = "";
    private String email = "";
    private String mobilePhoneNumber = "";
    ;
    private String homeTown = "";
    ;

    private String currentCity = "";
    ;
    private String currentDetailAddress = "";
    ;

    public UserInfo() {
    }

    public UserInfo(String nickName, String avatarUrl) {
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentDetailAddress() {
        return currentDetailAddress;
    }

    public void setCurrentDetailAddress(String currentDetailAddress) {
        this.currentDetailAddress = currentDetailAddress;
    }
}
