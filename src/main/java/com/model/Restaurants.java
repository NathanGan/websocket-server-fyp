package com.model;

public class Restaurants {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurants.id
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurants.name
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurants
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    public Restaurants(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurants.id
     *
     * @return the value of restaurants.id
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurants.name
     *
     * @return the value of restaurants.name
     *
     * @mbg.generated Sat Mar 10 22:37:40 HKT 2018
     */
    public String getName() {
        return name;
    }
}