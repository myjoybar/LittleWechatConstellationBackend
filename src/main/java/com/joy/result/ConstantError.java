package com.joy.result;

/**
 * Created by joybar on 2018/2/7.
 */
public enum ConstantError {

    BEFORE_ENTER_CONTROLLER_EXCEPTION(1, "before enter controller exception:"),
    IN_ENTER_CONTROLLER_EXCEPTION(2, "in enter controller exception:"),
    GLOBAL_EXCEPTION(2, "golobal exception:"),
    ERROR_CONSTELLATION_TYPE(4, "constellation type is invalid"),
    ERROR_CONSTELLATION_BROADCAST_MSG_EMPTY(5, "constellation broadcast msg  is empty"),
    ERROR_CONSTELLATION_BROADCAST_MSG_SAVE_OCCURS_ERROR(6, "constellation broadcast save  occurs error"),
    ERROR_NICKNAME_BROADCAST_MSG_EMPTY(7, "nickName is empty"),
    ERROR_AVATAR_URL_BROADCAST_MSG_EMPTY(8, "avatarUrl is empty"),
    ERROR_USER_INFO_SAVE_OCCURS_ERROR(9, "user info save  occurs error"),
    TIME_STAMP_ERROR(10, "Timestamp must be 13 digits"),
    NO_CONSTELLATION_BROADCAST_IN_DB_ERROR(11, "constellation broadcast msg  is not in db"),;

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
