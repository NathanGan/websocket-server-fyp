package com.dao;

import com.model.UserOrderHistory;
import com.model.UserOrderHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrderHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    long countByExample(UserOrderHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int deleteByExample(UserOrderHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int insert(UserOrderHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int insertSelective(UserOrderHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    List<UserOrderHistory> selectByExample(UserOrderHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    UserOrderHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int updateByExampleSelective(@Param("record") UserOrderHistory record, @Param("example") UserOrderHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int updateByExample(@Param("record") UserOrderHistory record, @Param("example") UserOrderHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int updateByPrimaryKeySelective(UserOrderHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    int updateByPrimaryKey(UserOrderHistory record);
}