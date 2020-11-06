package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.service.EventTrackService;
import cn.shop.mall.center.dao.EventTrackDao;
import cn.shop.mall.center.entity.EventTrackEntity;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventTrackServiceImpl implements EventTrackService {

    @Autowired
    private EventTrackDao eventTrackDao;

    @Override
    public ResponseVO save(String eventSource, String eventWho, String eventDo, String eventVersion, String eventDescription) {
        EventTrackEntity eventTrackEntity = new EventTrackEntity();
        eventTrackEntity.setEventDescription(eventDescription);
        eventTrackEntity.setEventDo(eventDo);
        eventTrackEntity.setEventSource(eventSource);
        eventTrackEntity.setEventVersion(eventVersion);
        eventTrackEntity.setEventWhen(new Date());
        eventTrackEntity.setEventWho(eventWho);
        eventTrackDao.save(eventTrackEntity);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO list() {
        Long count = eventTrackDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<EventTrackEntity> list = eventTrackDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }
}
