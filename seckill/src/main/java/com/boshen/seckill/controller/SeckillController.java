package com.boshen.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boshen.seckill.pojo.Order;
import com.boshen.seckill.pojo.SeckillOrder;
import com.boshen.seckill.pojo.User;
import com.boshen.seckill.service.IGoodsService;
import com.boshen.seckill.service.IOrderService;
import com.boshen.seckill.service.ISeckillOrderService;
import com.boshen.seckill.vo.GoodsVo;
import com.boshen.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user,Long goodsId){
        /*
        * 当用户还没有登录去登录页，如果用户已经登录了，那么判断用户是否可以秒杀，可以秒杀就去订单页，不能秒杀就去秒杀失败页
        * */
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
//        判断库存
        if(goodsVo.getStockCount()<1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }
//        判断订单（每个用户只能秒杀一件）
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(seckillOrder != null){
            model.addAttribute("errmsg",RespBeanEnum.REPEATE_ERROR.getMessage());
            return "secKillFail";
        }
        Order order = orderService.secKill(user,goodsVo);
        model.addAttribute("order",order);
        model.addAttribute("goods",goodsVo);
        return "orderDetail";
    }
}
