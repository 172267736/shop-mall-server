package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 应用用户表
 */
public class UserAppEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String headerImg;

    /**
     * 性别（0：未知；1：男；2：女；）
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickName;

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

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setHeaderImg(String headerImg){
        this.headerImg = headerImg;
    }

    public String getHeaderImg(){
        return headerImg;
    }

    public void setSex(Integer sex){
        this.sex = sex;
    }

    public Integer getSex(){
        return sex;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getNickName(){
        return nickName;
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
