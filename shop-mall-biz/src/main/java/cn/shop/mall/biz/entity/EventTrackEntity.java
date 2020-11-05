package cn.shop.mall.biz.entity;

import java.util.Date;

/**
 * 埋点表
 */
public class EventTrackEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 事件人
     */
    private String eventWho;

    /**
     * 事件
     */
    private String eventDo;

    /**
     * 发生时间
     */
    private Date eventWhen;

    /**
     * 版本号
     */
    private String eventVersion;

    /**
     * 事件来源
     */
    private String eventSource;

    /**
     * 时间说明
     */
    private String eventDescription;

    /**
     * 是否删除（0：否；1：删除）
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setEventWho(String eventWho) {
        this.eventWho = eventWho;
    }

    public String getEventWho() {
        return eventWho;
    }

    public void setEventDo(String eventDo) {
        this.eventDo = eventDo;
    }

    public String getEventDo() {
        return eventDo;
    }

    public void setEventWhen(Date eventWhen) {
        this.eventWhen = eventWhen;
    }

    public Date getEventWhen() {
        return eventWhen;
    }

    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    public String getEventVersion() {
        return eventVersion;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

}
