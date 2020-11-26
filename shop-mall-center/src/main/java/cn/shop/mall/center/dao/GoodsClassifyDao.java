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

    GoodsClassifyEntity getById(Long id);

    Long count(@Param("classifyName") String classifyName);

    List<GoodsClassifyEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("classifyName") String classifyName);

    List<GoodsClassifyEntity> listAll();

    List<GoodsClassifyEntity> getByParentId(Long parentId);
}
