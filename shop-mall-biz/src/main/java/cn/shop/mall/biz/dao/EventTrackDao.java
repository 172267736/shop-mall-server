package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.EventTrackEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 埋点表
 */
@Mapper
public interface EventTrackDao {

    Integer save(EventTrackEntity eventTrackEntity);

    Integer update(EventTrackEntity eventTrackEntity);

}
