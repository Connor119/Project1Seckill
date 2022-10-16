package com.boshen.seckill.controller;

import com.boshen.seckill.pojo.User;
import com.boshen.seckill.service.IGoodsService;
import com.boshen.seckill.service.IUserService;
import com.boshen.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    
    @Autowired
    private IUserService userService;

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(User user,Model model){//user 的校验应该放在进入这个controller之前
//        if(StringUtils.isEmpty(ticket)){
//            return "login";
//        }
////        User u = (User) session.getAttribute(ticket);
//        User u = userService.getUserByCookie(ticket, request, response);
//        if(null == u){
//            return "login";
//        }
//        User u = userService.getUserByCookie(ticket,request,response);
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
//        System.out.println(goodsService.findGoodsVo());

        return "goodsList";
    }

    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model,User user,@PathVariable Long goodsId){
//        System.out.println("++++++++++++++++++++++++++++");
        model.addAttribute("user", user);
//        System.out.println(user);
//        System.out.println(goodsService.findGoodsVoByGoodsId(goodsId));
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();

        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(nowDate);

        int secKillStatus = 0;

        if(nowDate.before(startDate)){

        }else if(nowDate.after(endDate)){
            secKillStatus = 2;
        }else{
            secKillStatus = 1;
        }

        System.out.println(secKillStatus);

        model.addAttribute("goods", goodsVo);
        model.addAttribute("secKillStatus",secKillStatus);
        return "goodsDetail";
    }
}
