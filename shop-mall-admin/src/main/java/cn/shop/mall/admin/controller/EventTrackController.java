package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.EventTrackParam;
import cn.shop.mall.admin.service.EventTrackService;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "埋点相关")
@RestController
@RequestMapping(value = "/event/track")
public class EventTrackController {

    @Autowired
    private EventTrackService eventTrackService;


    @ApiOperation("埋点")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody EventTrackParam eventTrackParam) {
        if (StringUtils.isEmpty(eventTrackParam.getWho())) {
            eventTrackParam.setWho(CurrentAuthorization.getUserName());
        }
        return eventTrackService.save(eventTrackParam.getEventSource(), eventTrackParam.getWhat(), eventTrackParam.getWho(), eventTrackParam.getVersion(), eventTrackParam.getDescription());
    }

    @ApiOperation("埋点列表")
    @GetMapping("/list")
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page,
                           @ApiParam(value = "事件标志") @RequestParam(required = false) String eventDo,
                           @ApiParam(value = "事件人") @RequestParam(required = false) String eventWho) {
        return eventTrackService.list(limit, page, eventDo, eventWho);
    }

}
