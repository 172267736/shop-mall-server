package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 管理用户表
 */
public class UserAdminEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户头像
     */
    private String headerImg;

    /**
     * 用户状态（0：正常；1：异常）
     */
    private Integer userState;

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

    public void setSalt(String salt){
        this.salt = salt;
    }

    public String getSalt(){
        return salt;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setHeaderImg(String headerImg){
        this.headerImg = headerImg;
    }

    public String getHeaderImg(){
        return headerImg;
    }

    public void setUserState(Integer userState){
        this.userState = userState;
    }

    public Integer getUserState(){
        return userState;
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
