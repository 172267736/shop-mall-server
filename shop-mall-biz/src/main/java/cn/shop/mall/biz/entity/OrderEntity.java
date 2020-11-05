package cn.shop.mall.biz.entity;

import cn.shop.mall.biz.entity.extend.OrderExtend;

import java.util.Date;

/**
 * 订单表
 */
public class OrderEntity extends OrderExtend {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 订单号
     */
    private Long orderNumber;

    /**
     * 三方订单号
     */
    private Integer thirdpartOrderNumber;

    /**
     * 订单状态（0：待支付；1：支付中；2：支付成功；3：支付失败）
     */
    private String status;

    /**
     * 是否超时（0：否；1：是）
     */
    private String expireState;

    /**
     * 支付用户
     */
    private Long payUserUniqueId;

    /**
     * 应支付金额（单位：元）
     */
    private Double shouldPayMoney;

    /**
     * 实支付金额（单位：元）
     */
    private Double actualPayMoney;

    /**
     * 支付类型（1：微信；2：支付宝；3：其他；）
     */
    private Integer payType;

    /**
     * 支付结果说明
     */
    private String payResultDescription;

    /**
     * 支付完成时间
     */
    private Date payOverTime;

    /**
     * 收货地址编号
     */
    private Long allocationAddressUniqueId;

    /**
     * 订单备注
     */
    private String orderRemark;

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

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setThirdpartOrderNumber(Integer thirdpartOrderNumber) {
        this.thirdpartOrderNumber = thirdpartOrderNumber;
    }

    public Integer getThirdpartOrderNumber() {
        return thirdpartOrderNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setExpireState(String expireState) {
        this.expireState = expireState;
    }

    public String getExpireState() {
        return expireState;
    }

    public void setPayUserUniqueId(Long payUserUniqueId) {
        this.payUserUniqueId = payUserUniqueId;
    }

    public Long getPayUserUniqueId() {
        return payUserUniqueId;
    }

    public void setShouldPayMoney(Double shouldPayMoney) {
        this.shouldPayMoney = shouldPayMoney;
    }

    public Double getShouldPayMoney() {
        return shouldPayMoney;
    }

    public void setActualPayMoney(Double actualPayMoney) {
        this.actualPayMoney = actualPayMoney;
    }

    public Double getActualPayMoney() {
        return actualPayMoney;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayResultDescription(String payResultDescription) {
        this.payResultDescription = payResultDescription;
    }

    public String getPayResultDescription() {
        return payResultDescription;
    }

    public void setPayOverTime(Date payOverTime) {
        this.payOverTime = payOverTime;
    }

    public Date getPayOverTime() {
        return payOverTime;
    }

    public void setAllocationAddressUniqueId(Long allocationAddressUniqueId) {
        this.allocationAddressUniqueId = allocationAddressUniqueId;
    }

    public Long getAllocationAddressUniqueId() {
        return allocationAddressUniqueId;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getOrderRemark() {
        return orderRemark;
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
