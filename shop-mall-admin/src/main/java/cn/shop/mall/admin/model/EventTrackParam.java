package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加埋点")
public class EventTrackParam {

    @ApiModelProperty(value = "事件来源（android、ios、browser、server）")
    private String eventSource;

    @ApiModelProperty(value = "事件人")
    private String who;

    @ApiModelProperty(value = "事件标志")
    private String what;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "说明")
    private String description;

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
