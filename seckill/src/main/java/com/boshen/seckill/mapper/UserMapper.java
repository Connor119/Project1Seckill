package com.boshen.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boshen.seckill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author boshen
 * @since 2022-08-05
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
