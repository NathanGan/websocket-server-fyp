package com.util;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * Created by nathan on 2017/11/15.
 */
public class JSONUtil {
    private static Gson gson = new Gson();

    public static String toJSON(Object obj){
        if (obj==null){
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(obj);
    }
}
