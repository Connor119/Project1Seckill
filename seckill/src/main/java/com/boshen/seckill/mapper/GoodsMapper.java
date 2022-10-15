package com.boshen.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boshen.seckill.pojo.Goods;
import com.boshen.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author boshen
 * @since 2022-08-07
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
