package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.GoodsClassifyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类表
 */
@Mapper
public interface GoodsClassifyDao {

    Integer save(GoodsClassifyEntity goodsClassifyEntity);

    Integer update(GoodsClassifyEntity goodsClassifyEntity);

    Long count();

    List<GoodsClassifyEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset);

}
