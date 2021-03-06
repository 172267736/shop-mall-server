package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 字典表
 */
public class KvStoreEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 唯一键
     */
    private String keyFlag;

    /**
     * 组名一
     */
    private String firstName;

    /**
     * 组名二
     */
    private String lastName;

    /**
     * 值
     */
    private String storeValue;

    /**
     * key说明
     */
    private String keyDescription;

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

    public String getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(String keyFlag) {
        this.keyFlag = keyFlag;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStoreValue() {
        return storeValue;
    }

    public void setStoreValue(String storeValue) {
        this.storeValue = storeValue;
    }

    public void setKeyDescription(String keyDescription){
        this.keyDescription = keyDescription;
    }

    public String getKeyDescription(){
        return keyDescription;
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
