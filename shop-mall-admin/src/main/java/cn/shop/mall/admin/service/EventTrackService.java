package cn.shop.mall.admin.service;

import cn.shop.mall.common.vo.ResponseVO;

public interface EventTrackService {

    ResponseVO save(String eventSource, String eventWho, String eventDo, String eventVersion, String eventDescription);

}
