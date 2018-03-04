package com.joy.entity.enumconfig;

/**
 * Created by joybar on 2018/2/5.
 */
public enum UserRoleConfig {
    Admin(1,"admin"),
    commonUser(2,"commonUser"),
    AllUser(3,"all");

    UserRoleConfig(int roleCode, String roleStr) {
        this.roleCode = roleCode;
        this.roleStr = roleStr;
    }

    private int roleCode;
    private String roleStr;

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleStr() {
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }
}
