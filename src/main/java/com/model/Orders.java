package com.model;

public class Orders {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.id
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.sid
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    private Integer sid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.rid
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.restaurant_id
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    private Integer restaurantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    public Orders(Integer id, Integer sid, Integer rid, Integer restaurantId) {
        this.id = id;
        this.sid = sid;
        this.rid = rid;
        this.restaurantId = restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.id
     *
     * @return the value of orders.id
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.sid
     *
     * @return the value of orders.sid
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.rid
     *
     * @return the value of orders.rid
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.restaurant_id
     *
     * @return the value of orders.restaurant_id
     *
     * @mbg.generated Mon Mar 12 17:09:41 HKT 2018
     */
    public Integer getRestaurantId() {
        return restaurantId;
    }
}