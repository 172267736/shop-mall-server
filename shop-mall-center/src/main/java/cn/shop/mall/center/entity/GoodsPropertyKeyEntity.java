package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 商品属性键表
 */
public class GoodsPropertyKeyEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 商品编号
     */
    private Long goodsUniqueId;

    /**
     * 商品属性key
     */
    private String propertyKey;

    /**
     * 商品属性名称
     */
    private String propertyName;

    /**
     * 商品属性key排序
     */
    private Integer propertyKeySort;

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

    public void setGoodsUniqueId(Long goodsUniqueId){
        this.goodsUniqueId = goodsUniqueId;
    }

    public Long getGoodsUniqueId(){
        return goodsUniqueId;
    }

    public void setPropertyKey(String propertyKey){
        this.propertyKey = propertyKey;
    }

    public String getPropertyKey(){
        return propertyKey;
    }

    public void setPropertyName(String propertyName){
        this.propertyName = propertyName;
    }

    public String getPropertyName(){
        return propertyName;
    }

    public void setPropertyKeySort(Integer propertyKeySort){
        this.propertyKeySort = propertyKeySort;
    }

    public Integer getPropertyKeySort(){
        return propertyKeySort;
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
