package com.zld.weixin.controller;

import com.zld.weixin.mapper.CardInfoMapper;
import com.zld.weixin.model.CardInfo;
import com.zld.weixin.model.CardInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */
@RestController
public class LoadOthersCardInfo {
    @Autowired
    CardInfoMapper cardInfoMapper;
    @RequestMapping(value = "/loadOthersCardInfo/{id}",method = RequestMethod.GET)
    public List<CardInfo> selectOthersCard(@PathVariable("id") String id) {
        System.out.println(id);
        CardInfoExample selectByOpenid = new CardInfoExample();
        CardInfoExample.Criteria selectByOpenid_criteria = selectByOpenid.createCriteria();
        selectByOpenid_criteria.andIdEqualTo(id);
        List<CardInfo> cardInfos = cardInfoMapper.selectByExample(selectByOpenid);
        System.out.println("others:" + cardInfos);
        return cardInfos;
    }
}
