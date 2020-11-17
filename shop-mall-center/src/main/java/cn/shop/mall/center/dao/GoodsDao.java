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

    List<GoodsEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset,
                           @Param("status") Integer status, @Param("goodsTag") String goodsTag,
                           @Param("goodsName") String goodsName, @Param("belongClassifyId") Long belongClassifyId);

    Long count(@Param("status") Integer status, @Param("goodsTag") String goodsTag,
               @Param("goodsName") String goodsName, @Param("belongClassifyId") Long belongClassifyId);


    List<GoodsEntity> querGoods(GoodsEntity goodsEntity, @Param("limit")Integer limit,
                                @Param("offset") Integer offset);
}
