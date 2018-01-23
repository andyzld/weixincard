package com.zld.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.zld.weixin.mapper.CardInfoMapper;
import com.zld.weixin.model.CardInfo;
import com.zld.weixin.model.CardInfoExample;
import com.zld.weixin.model.Login.LoginReturnData;
import com.zld.weixin.util.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/12/26.
 */
@RestController
public class LoginController {
    private LoginReturnData loginReturnData ;
    @Autowired
    CardInfoMapper cardInfoMapper;
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/login" )
    //, String encryptedData, String iv,
    public LoginReturnData login(String code, HttpSession session){
        loginReturnData = new LoginReturnData();
        Random random = new Random();
        String getSessionUrl = WeixinUtil.getSessionKeyUrl(code);
        HttpHeaders headers = new HttpHeaders();//header参数
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject body = restTemplate.getForEntity(getSessionUrl,JSONObject.class,headers).getBody();
        String openid = (String)body.get("openid");
        String session_key = (String)body.get("session_key");
        System.out.println(openid);
        String rd = String.valueOf(random.nextInt());

        session.setAttribute(rd,openid +" "+ session_key);
        String sessionId = session.getId();
        CardInfoExample selectByOpenId = new CardInfoExample();
        CardInfoExample.Criteria selectByOpenIdCriteria = selectByOpenId.createCriteria();
        selectByOpenIdCriteria.andIdEqualTo(openid);
        List<CardInfo> cardInfos = cardInfoMapper.selectByExample(selectByOpenId);
        if(cardInfos.size()==0){
            CardInfo cardInfo = new CardInfo();
            cardInfo.setId(openid);
            cardInfo.setCompany("null");
            cardInfoMapper.insert(cardInfo);
            loginReturnData.setNewUser(true);
        }
        else{
            System.out.println("size:" + cardInfos.size());
            for(CardInfo c :cardInfos){
                System.out.println(c.getId() + c.getCompany());
                if(c.getCompany().equals("null")){
                    loginReturnData.setNewUser(true);
                }else{
                    System.out.println(c.getCompany().getClass());
                    loginReturnData.setNewUser(false);
                    break;

                }
            }
        }
        System.out.println("newUser: " + loginReturnData.isNewUser());
        System.out.println("sessionId:" + sessionId);
        loginReturnData.setSessionKey(rd);
        loginReturnData.setSessionId(sessionId);
        loginReturnData.setOpenId(openid);
        System.out.println(loginReturnData);
        return loginReturnData;
    }

}
