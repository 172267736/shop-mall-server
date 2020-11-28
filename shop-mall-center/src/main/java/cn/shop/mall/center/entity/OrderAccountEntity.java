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
     * 单价
     */
    private Double singlePrice;

    /**
     * 购买数量
     */
    private Integer buyNumber;

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

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 大图
     */
    private String bigImgs;



    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setOrderUniqueId(Long orderUniqueId) {
        this.orderUniqueId = orderUniqueId;
    }

    public Long getOrderUniqueId() {
        return orderUniqueId;
    }

    public void setGoodsUniqueId(Long goodsUniqueId) {
        this.goodsUniqueId = goodsUniqueId;
    }

    public Long getGoodsUniqueId() {
        return goodsUniqueId;
    }

    public void setGoodsSkuUniqueId(Long goodsSkuUniqueId) {
        this.goodsSkuUniqueId = goodsSkuUniqueId;
    }

    public Long getGoodsSkuUniqueId() {
        return goodsSkuUniqueId;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public void setAccountRemark(String accountRemark) {
        this.accountRemark = accountRemark;
    }

    public String getAccountRemark() {
        return accountRemark;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBigImgs() {
        return bigImgs;
    }

    public void setBigImgs(String bigImgs) {
        this.bigImgs = bigImgs;
    }
}
