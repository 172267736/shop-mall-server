package cn.shop.mall.center.entity;

import cn.shop.mall.center.entity.extend.OrderExtend;

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
    private String orderNumber;

    /**
     * 三方订单号
     */
    private String thirdpartOrderNumber;

    /**
     * 订单状态（0：待支付；1：支付中；2：支付成功；3：支付失败）
     */
    private Integer status;

    /**
     * 是否超时（0：否；1：是）
     */
    private Integer expireState;

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

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getThirdpartOrderNumber() {
        return thirdpartOrderNumber;
    }

    public void setThirdpartOrderNumber(String thirdpartOrderNumber) {
        this.thirdpartOrderNumber = thirdpartOrderNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExpireState() {
        return expireState;
    }

    public void setExpireState(Integer expireState) {
        this.expireState = expireState;
    }

    public Long getPayUserUniqueId() {
        return payUserUniqueId;
    }

    public void setPayUserUniqueId(Long payUserUniqueId) {
        this.payUserUniqueId = payUserUniqueId;
    }

    public Double getShouldPayMoney() {
        return shouldPayMoney;
    }

    public void setShouldPayMoney(Double shouldPayMoney) {
        this.shouldPayMoney = shouldPayMoney;
    }

    public Double getActualPayMoney() {
        return actualPayMoney;
    }

    public void setActualPayMoney(Double actualPayMoney) {
        this.actualPayMoney = actualPayMoney;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayResultDescription() {
        return payResultDescription;
    }

    public void setPayResultDescription(String payResultDescription) {
        this.payResultDescription = payResultDescription;
    }

    public Date getPayOverTime() {
        return payOverTime;
    }

    public void setPayOverTime(Date payOverTime) {
        this.payOverTime = payOverTime;
    }

    public Long getAllocationAddressUniqueId() {
        return allocationAddressUniqueId;
    }

    public void setAllocationAddressUniqueId(Long allocationAddressUniqueId) {
        this.allocationAddressUniqueId = allocationAddressUniqueId;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
