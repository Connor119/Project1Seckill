package com.boshen.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boshen.seckill.exception.GlobalException;
import com.boshen.seckill.mapper.UserMapper;
import com.boshen.seckill.pojo.User;
import com.boshen.seckill.service.IUserService;
import com.boshen.seckill.utils.CookieUtil;
import com.boshen.seckill.utils.MD5Util;
import com.boshen.seckill.utils.UUIDUtil;
import com.boshen.seckill.vo.LoginVo;
import com.boshen.seckill.vo.RespBean;
import com.boshen.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author boshen
 * @since 2022-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public RespBean doLogin(LoginVo loginvo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginvo.getMobile();
        String password = loginvo.getPassword();


        User user = userMapper.selectById(mobile);
        if(null == user){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//            可以由return变成抛出异常
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
//        if(!MD5Util.inputPassToDBPass(password, user.getSalt()).equals(user.getPassword())){
//            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
//        }
//        生成cookie
        String ticket = UUIDUtil.uuid();
//        request.getSession().setAttribute(ticket,user);
        redisTemplate.opsForValue().set("user:"+ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByCookie(String userTicket,HttpServletRequest request, HttpServletResponse response) {
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        User o = (User)redisTemplate.opsForValue().get("user:" + userTicket);
        if(o!=null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return o;
    }
}
