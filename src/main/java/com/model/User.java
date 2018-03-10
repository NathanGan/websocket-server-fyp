package com.model;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.info
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private String info;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_date
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_deleted
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Boolean isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    private Integer phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public User(Integer id, String name, String password, String info, Date createDate, Boolean isDeleted, Integer phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.info = info;
        this.createDate = createDate;
        this.isDeleted = isDeleted;
        this.phone = phone;
    }
    public User(String name, String password){

    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.info
     *
     * @return the value of user.info
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_date
     *
     * @return the value of user.create_date
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_deleted
     *
     * @return the value of user.is_deleted
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbg.generated Tue Dec 05 21:16:15 HKT 2017
     */
    public Integer getPhone() {
        return phone;
    }

    private String type;
    private Integer share_time;
    private Integer vacancy;
    private Location location;
    public User(){

    }
    public User(int id, String name, String type, int share_times, int vacancy, Location location){
        this.id = id;
        this.name = name;
        this.type = type;
        this.share_time = share_times;
        this.vacancy = vacancy;
        this.location = location;
    }
    public String getType(){
        return type;
    }
    public int getShareTime(){
        return share_time;
    }
    public int getVacancy(){
        return vacancy;
    }
    public Location getLocation(){
        return location;
    }
}