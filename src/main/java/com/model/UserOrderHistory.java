package com.model;

public class UserOrderHistory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_history.id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_history.user_id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_history.order_id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Integer orderId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_order_history
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public UserOrderHistory(Integer id, Integer userId, Integer orderId) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_history.id
     *
     * @return the value of user_order_history.id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_history.user_id
     *
     * @return the value of user_order_history.user_id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_history.order_id
     *
     * @return the value of user_order_history.order_id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Integer getOrderId() {
        return orderId;
    }
}