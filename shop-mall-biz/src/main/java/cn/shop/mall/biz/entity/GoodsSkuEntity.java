package cn.shop.mall.biz.entity;

import java.util.Date;

/**
 * 商品库存表
 */
public class GoodsSkuEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 商品编号
     */
    private Long goodsUniqueId;

    /**
     * 商品库存
     */
    private Integer goodsStock;

    /**
     * 小图
     */
    private String smallImg;

    /**
     * 价格
     */
    private Double price;

    private String skuFlag;

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

    public String getSkuFlag() {
        return skuFlag;
    }

    public void setSkuFlag(String skuFlag) {
        this.skuFlag = skuFlag;
    }

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

    public void setGoodsStock(Integer goodsStock){
        this.goodsStock = goodsStock;
    }

    public Integer getGoodsStock(){
        return goodsStock;
    }

    public void setSmallImg(String smallImg){
        this.smallImg = smallImg;
    }

    public String getSmallImg(){
        return smallImg;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return price;
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
