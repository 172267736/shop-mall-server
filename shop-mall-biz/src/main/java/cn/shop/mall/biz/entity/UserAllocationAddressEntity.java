package cn.shop.mall.biz.entity;

import java.util.Date;

/**
 * 配送地址表
 */
public class UserAllocationAddressEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 用户编号
     */
    private Long userUniqueId;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 路/街道
     */
    private String road;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 地址标签
     */
    private String tag;

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

    public void setUniqueId(Long uniqueId){
        this.uniqueId = uniqueId;
    }

    public Long getUniqueId(){
        return uniqueId;
    }

    public void setUserUniqueId(Long userUniqueId){
        this.userUniqueId = userUniqueId;
    }

    public Long getUserUniqueId(){
        return userUniqueId;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public String getProvince(){
        return province;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setRegion(String region){
        this.region = region;
    }

    public String getRegion(){
        return region;
    }

    public void setRoad(String road){
        this.road = road;
    }

    public String getRoad(){
        return road;
    }

    public void setAddressDetail(String addressDetail){
        this.addressDetail = addressDetail;
    }

    public String getAddressDetail(){
        return addressDetail;
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    public String getTag(){
        return tag;
    }

    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }

    public Integer getDeleted(){
        return deleted;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getCreateDate(){
        return createDate;
    }

    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

}
