package com.joy.result;

/**
 * Created by joybar on 2018/2/7.
 */
public enum ConstantError {

    ERROR_CONSTELLATION_TYPE(1,"constellation type is invalid"),
    ERROR_CONSTELLATION_BROADCAST_MSG_EMPTY(2,"constellation broadcast msg  is empty"),
    ERROR_CONSTELLATION_BROADCAST_MSG_SAVE_OCCURS_ERROR(3,"constellation broadcast save  occurs error"),
    ERROR_NICKNAME_BROADCAST_MSG_EMPTY(4,"nickName is empty"),
    ERROR_AVATAR_URL_BROADCAST_MSG_EMPTY(5,"avatarUrl is empty"),
    ERROR_USER_INFO_SAVE_OCCURS_ERROR(6,"user info save  occurs error"),
    ;

    ConstantError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }


}
