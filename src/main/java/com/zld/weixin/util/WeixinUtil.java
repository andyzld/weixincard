package com.zld.weixin.util;

/**
 * Created by Administrator on 2017/12/26.
 */
public class WeixinUtil {
    public static final String APP_URL = "https://zld.mynatapp.cc";
    public static final String eq = "=";
    public static final String and = "&";
    public static final String _APPID = "appid";
    public static final String _SECRET = "secret";
    public static final String _JSCODE = "js_code";
    public static final String _GRANT_TYPE = "grant_type";
    public static final String APPID = "wx488adb54f215349b";
    public static final String SECRET = "cf9a89893552e88d4e16ddffeb268e4d";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String getSessionKeyUrl = "https://api.weixin.qq.com/sns/jscode2session?";
    public static String getSessionKeyUrl(String code){
        return getSessionKeyUrl + _APPID + eq + APPID +
                and + _SECRET + eq + SECRET +
                and + _JSCODE + eq + code +
                and +_GRANT_TYPE +eq+ GRANT_TYPE;
    }
}
