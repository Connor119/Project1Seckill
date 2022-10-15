package com.boshen.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshen.seckill.pojo.User;
import com.boshen.seckill.vo.LoginVo;
import com.boshen.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author boshen
 * @since 2022-08-05
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginvo, HttpServletRequest request, HttpServletResponse response);

    User getUserByCookie(String userTicket,HttpServletRequest request, HttpServletResponse response);
}
