package com.zld.pay.model.Login;

/**
 * Created by Administrator on 2017/12/28.
 */
public class LoginReturnData {
    private String sessionKey;
    private boolean isNewUser;
    private String sessionId;
    public String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LoginReturnData() {
    }

    public LoginReturnData(String sessionKey, boolean isNewUser, String sessionId, String openId) {
        this.sessionKey = sessionKey;
        this.isNewUser = isNewUser;
        this.sessionId = sessionId;
        this.openId = openId;
    }

    public LoginReturnData(String sessionKey, boolean isNewUser) {
        this.sessionKey = sessionKey;
        this.isNewUser = isNewUser;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }

    @Override
    public String toString() {
        return "LoginReturnData{" +
                "sessionKey='" + sessionKey + '\'' +
                ", isNewUser=" + isNewUser +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
