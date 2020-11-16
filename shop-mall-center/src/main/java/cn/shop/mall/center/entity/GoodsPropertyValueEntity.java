package cn.shop.mall.center.entity;

import cn.shop.mall.center.entity.extend.GoodsPropertyValueExtend;

import java.util.Date;

/**
 * 商品属性值表
 */
public class GoodsPropertyValueEntity extends GoodsPropertyValueExtend {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 商品属性编号
     */
    private Long goodsPropertyKeyUniqueId;

    /**
     * 商品属性值
     */
    private String propertyValue;

    /**
     * 价格涨幅（单位：元）
     */
    private Double valueCost;

    private String valueFlag;

    private Integer propertyValueSort;

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

    public String getValueFlag() {
        return valueFlag;
    }

    public void setValueFlag(String valueFlag) {
        this.valueFlag = valueFlag;
    }

    public Integer getPropertyValueSort() {
        return propertyValueSort;
    }

    public void setPropertyValueSort(Integer propertyValueSort) {
        this.propertyValueSort = propertyValueSort;
    }

    public void setUniqueId(Long uniqueId){
        this.uniqueId = uniqueId;
    }

    public Long getUniqueId(){
        return uniqueId;
    }

    public void setGoodsPropertyKeyUniqueId(Long goodsPropertyKeyUniqueId){
        this.goodsPropertyKeyUniqueId = goodsPropertyKeyUniqueId;
    }

    public Long getGoodsPropertyKeyUniqueId(){
        return goodsPropertyKeyUniqueId;
    }

    public void setPropertyValue(String propertyValue){
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue(){
        return propertyValue;
    }

    public Double getValueCost() {
        return valueCost;
    }

    public void setValueCost(Double valueCost) {
        this.valueCost = valueCost;
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
