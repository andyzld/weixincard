package com.zld.pay.controller;

import com.zld.weixin.mapper.CardInfoMapper;
import com.zld.weixin.model.CardInfo;
import com.zld.weixin.model.CardInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
@RestController
public class LoadCardInfo {
    @Autowired
    CardInfoMapper cardInfoMapper;
    @RequestMapping(value = "/loadCardInfo/{session_key}",method = RequestMethod.GET)
    public List<CardInfo> selectCard(@PathVariable("session_key") String session_key, HttpSession session){
        String session_value = (String)session.getAttribute(session_key);
        System.out.println(session_value);
        String[] openid_and_secret = session_value.split(" ");
        String openid = openid_and_secret[0];
        String secret = openid_and_secret[1];
        CardInfoExample selectByOpenid = new CardInfoExample();
        CardInfoExample.Criteria selectByOpenid_criteria = selectByOpenid.createCriteria();
        selectByOpenid_criteria.andIdEqualTo(openid);
        List<CardInfo> cardInfos = cardInfoMapper.selectByExample(selectByOpenid);
        return cardInfos;
    }


}
