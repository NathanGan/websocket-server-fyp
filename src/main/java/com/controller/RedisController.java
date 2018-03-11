package com.controller;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by nathan on 2017/11/16.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @ResponseBody
    @RequestMapping(value="/userInfo",method=RequestMethod.GET)
    public String getUserInfo(@RequestParam int uid) throws IOException{
        UserService userService = new UserServiceImpl();
        User user = userService.getUserByID(uid);
        if(user!=null){
            return "您要获取的用户名称是："+user.getName();
        }
        return "获取用户信息失败";
    }
}
