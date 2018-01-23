package com.zld.pay.controller;

import com.zld.weixin.mapper.CardInfoMapper;
import com.zld.weixin.mapper.opHistoryMapper;
import com.zld.weixin.model.CardInfo;
import com.zld.weixin.model.CardInfoExample;
import com.zld.weixin.model.opHistory;
import com.zld.weixin.model.opHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/12/31.
 */
@RestController
public class UpdateCardController {
    @Autowired
    CardInfoMapper cardInfoMapper;
    @Autowired
    opHistoryMapper opHis;
    @RequestMapping("/updatecard")
    public String updateTagNum(CardInfo changedCard){
        CardInfoExample updateTagNumExample = new CardInfoExample();
        System.out.println("ch:"+changedCard);
        CardInfoExample.Criteria criteria = updateTagNumExample.createCriteria();
        criteria.andIdEqualTo(changedCard.getId());
        cardInfoMapper.updateByExampleSelective(changedCard,updateTagNumExample);
        return null;
    }
    @RequestMapping(value = "/insertOpHistory",method = RequestMethod.POST)
    public String insertOpHistory(@RequestBody opHistory oph){
        System.out.println(oph);
        String opText = oph.getDate() + oph.getName();
        switch (oph.getOptype()) {
            case "zan0":
                opText += "取消赞了这张卡片";
                break;
            case "zan1":
                opText += "赞了这张卡片";
                break;
            case "collection0":
                opText += "取消收藏了这张卡片";
                break;
            case "collection1":
                opText += "收藏了这张卡片";
                break;
            case "watch1":
                opText += "关注了这张卡片";
                break;
            case "watch0":
                opText += "取消关注了这张卡片";
                break;
            case "browser":
                opText += "浏览了这张卡片";
        }
        oph.setOptext(opText);
        opHis.insert(oph);
        return null;
    }

}
