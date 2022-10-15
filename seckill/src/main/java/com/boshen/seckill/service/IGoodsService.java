package com.boshen.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshen.seckill.pojo.Goods;
import com.boshen.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author boshen
 * @since 2022-08-07
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);

}
