package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.EventTrackEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 埋点表
 */
@Mapper
public interface EventTrackDao {

    Integer save(EventTrackEntity eventTrackEntity);

    Integer update(EventTrackEntity eventTrackEntity);

}
