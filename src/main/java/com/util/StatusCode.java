package com.util;

/**
 * Created by nathan on 2017/11/7.
 */
public class StatusCode {

    private int code;
    private String describe;
    public StatusCode(int code, String describe){
        this.code = code;
        this.describe = describe;
    }

    public int getCode(){
        return code;
    }
    public String getDescribe(){
        return describe;
    }

}
