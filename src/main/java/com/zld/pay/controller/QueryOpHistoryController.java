package com.zld.pay.controller;

import com.zld.weixin.mapper.opHistoryMapper;
import com.zld.weixin.model.opHistory;
import com.zld.weixin.model.opHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */
@RestController
public class QueryOpHistoryController {
    @Autowired
    opHistoryMapper ophMapper;
    @RequestMapping("queryOpHistory")
    public List<opHistory> queryOpHistory(@RequestBody opHistory oph){
        String opType1 = oph.getOptype() + "1";
        String opType2 = oph.getOptype() + "0";
        opHistoryExample opEx = new opHistoryExample();
        opHistoryExample.Criteria criteria = opEx.createCriteria();
        criteria.andCardidEqualTo(oph.getCardid());
        criteria.andOptypeEqualTo(opType1);
        opHistoryExample.Criteria criteriaOp = opEx.createCriteria();
        criteriaOp.andCardidEqualTo(oph.getCardid());
        criteriaOp.andOptypeEqualTo(opType2);
        opEx.or(criteriaOp);
        List<opHistory> opHistories = ophMapper.selectByExample(opEx);
        System.out.println("ss:" + opHistories);
        return opHistories;
    }
}
