package com.zld.pay.mapper;

import com.zld.weixin.model.opHistory;
import com.zld.weixin.model.opHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface opHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    long countByExample(opHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    int deleteByExample(opHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    int insert(opHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    int insertSelective(opHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    List<opHistory> selectByExample(opHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    int updateByExampleSelective(@Param("record") opHistory record, @Param("example") opHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table op_history
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    int updateByExample(@Param("record") opHistory record, @Param("example") opHistoryExample example);
}