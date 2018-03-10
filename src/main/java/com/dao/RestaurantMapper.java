package com.dao;

import com.model.Restaurant;
import com.model.RestaurantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RestaurantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    long countByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int deleteByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int insert(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int insertSelective(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    List<Restaurant> selectByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    Restaurant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int updateByExampleSelective(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int updateByExample(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int updateByPrimaryKeySelective(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sat Mar 10 23:22:19 HKT 2018
     */
    int updateByPrimaryKey(Restaurant record);
}