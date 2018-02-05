package com.joy.entity.enumconfig;

/**
 * Created by joybar on 2018/2/5.
 */
public enum UserRole {
    MALE(1,"male");
    MALE(1,"male");
    UserRole(int roleCode, String gender) {
        this.roleCode = roleCode;
        this.gender = gender;
    }
    private int roleCode;
    private String gender;
}
