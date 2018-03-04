package com.joy.entity.enumconfig;

/**
 * Created by joybar on 2018/2/5.
 */
public enum UserGenderConfig {
    UNKNOWN(0,"unknown"),
    MALE(1,"male"),
    FEMALE(2,"female");

    UserGenderConfig(int genderCode, String gender) {
        this.genderCode = genderCode;
        this.gender = gender;
    }

    private int genderCode;
    private String gender;

    public int getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(int genderCode) {
        this.genderCode = genderCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
