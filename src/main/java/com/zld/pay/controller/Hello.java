package com.zld.pay.controller;

import com.zld.weixin.mapper.CardInfoMapper;
import com.zld.weixin.model.CardInfo;
import com.zld.weixin.model.CardInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
@RestController
public class Hello {
    @Autowired
    CardInfoMapper cardMapper;
    @RequestMapping("/hello")
    public List<CardInfo> hello(){
        CardInfoExample example = new CardInfoExample();
        CardInfoExample.Criteria criteria = example.createCriteria();
        List<CardInfo> cardInfos = cardMapper.selectByExample(null);
        return cardInfos;
    }
    @RequestMapping("/test")
    public String ww(){
        return "hello";
    }
}
