package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.EventTrackEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 埋点表
 */
@Mapper
public interface EventTrackDao {

    Integer save(EventTrackEntity eventTrackEntity);

    Integer update(EventTrackEntity eventTrackEntity);

    Long count(@Param("eventDo") String eventDo, @Param("eventWho") String eventWho);

    List<EventTrackEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("eventDo") String eventDo, @Param("eventWho") String eventWho);

}
