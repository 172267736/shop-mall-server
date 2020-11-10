package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品表
 */
@Mapper
public interface GoodsDao {

    Integer save(GoodsEntity goodsEntity);

    Integer update(GoodsEntity goodsEntity);

    GoodsEntity getById(Long id);

    List<GoodsEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset);

    Long count();

}
