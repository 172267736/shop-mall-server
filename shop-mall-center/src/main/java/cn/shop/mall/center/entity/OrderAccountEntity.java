package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 订单清单表
 */
public class OrderAccountEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 订单编号
     */
    private Long orderUniqueId;

    /**
     * 商品编号
     */
    private Long goodsUniqueId;

    /**
     * 库存编号
     */
    private Long goodsSkuUniqueId;

    /**
     * 价格
     */
    private Double price;

    /**
     * 商品信息
     */
    private String goodsInformation;

    /**
     * 清单备注
     */
    private String accountRemark;

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

    public void setOrderUniqueId(Long orderUniqueId){
        this.orderUniqueId = orderUniqueId;
    }

    public Long getOrderUniqueId(){
        return orderUniqueId;
    }

    public void setGoodsUniqueId(Long goodsUniqueId){
        this.goodsUniqueId = goodsUniqueId;
    }

    public Long getGoodsUniqueId(){
        return goodsUniqueId;
    }

    public void setGoodsSkuUniqueId(Long goodsSkuUniqueId){
        this.goodsSkuUniqueId = goodsSkuUniqueId;
    }

    public Long getGoodsSkuUniqueId(){
        return goodsSkuUniqueId;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    public void setGoodsInformation(String goodsInformation){
        this.goodsInformation = goodsInformation;
    }

    public String getGoodsInformation(){
        return goodsInformation;
    }

    public void setAccountRemark(String accountRemark){
        this.accountRemark = accountRemark;
    }

    public String getAccountRemark(){
        return accountRemark;
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
