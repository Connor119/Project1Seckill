package com.boshen.seckill.controller;


import com.boshen.seckill.pojo.User;
import com.boshen.seckill.rabbitmq.MQSender;
import com.boshen.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author boshen
 * @since 2022-08-05
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MQSender sender;


    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }


    @RequestMapping("/mq")
    @ResponseBody
    public void mq(){
        sender.send("hello");
    }

    @RequestMapping("/mq1")
    @ResponseBody
    public void mq1(){
        sender.send01("hello red");
    }
    @RequestMapping("/mq2")
    @ResponseBody
    public void mq2(){
        sender.send02("hello green");
    }


}
