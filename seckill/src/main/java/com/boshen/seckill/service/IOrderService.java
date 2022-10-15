package com.boshen.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshen.seckill.pojo.Order;
import com.boshen.seckill.pojo.User;
import com.boshen.seckill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author boshen
 * @since 2022-08-07
 */
public interface IOrderService extends IService<Order> {

    Order secKill(User user, GoodsVo goodsVo);

}
