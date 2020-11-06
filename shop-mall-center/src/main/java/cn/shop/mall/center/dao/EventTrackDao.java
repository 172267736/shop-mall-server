package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.EventTrackEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 埋点表
 */
@Mapper
public interface EventTrackDao {

    Integer save(EventTrackEntity eventTrackEntity);

    Integer update(EventTrackEntity eventTrackEntity);

    Long count();

    List<EventTrackEntity> list();

}
