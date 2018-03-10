package com.dao;

import com.model.UserRestaurantHistory;
import com.model.UserRestaurantHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRestaurantHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    long countByExample(UserRestaurantHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int deleteByExample(UserRestaurantHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int insert(UserRestaurantHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int insertSelective(UserRestaurantHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    List<UserRestaurantHistory> selectByExample(UserRestaurantHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    UserRestaurantHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int updateByExampleSelective(@Param("record") UserRestaurantHistory record, @Param("example") UserRestaurantHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int updateByExample(@Param("record") UserRestaurantHistory record, @Param("example") UserRestaurantHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int updateByPrimaryKeySelective(UserRestaurantHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_restaurant_history
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    int updateByPrimaryKey(UserRestaurantHistory record);
}