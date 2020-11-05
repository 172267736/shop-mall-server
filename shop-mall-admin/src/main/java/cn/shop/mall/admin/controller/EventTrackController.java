package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.service.EventTrackService;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseVO save(@ApiParam(value = "事件来源（android、ios、browser、server）", required = true) @RequestParam String eventSource,
                           @ApiParam(value = "事件标志", required = true) @RequestParam String what,
                           @ApiParam(value = "事件人") @RequestParam(required = false) String who,
                           @ApiParam(value = "版本号") @RequestParam(required = false) String version,
                           @ApiParam(value = "说明") @RequestParam(required = false) String description) {
        if (StringUtils.isEmpty(who)) {
            who = CurrentAuthorization.getUserName();
        }
        return eventTrackService.save(eventSource, what, who, version, description);
    }

}
