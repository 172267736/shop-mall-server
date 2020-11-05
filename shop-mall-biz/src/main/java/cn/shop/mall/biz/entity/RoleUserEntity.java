package cn.shop.mall.biz.entity;

import java.util.Date;

/**
 * 角色用户表
 */
public class RoleUserEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 用户编号
     */
    private Long userUniqueId;

    /**
     * 角色编号
     */
    private Long roleUniqueId;

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

    public void setUserUniqueId(Long userUniqueId){
        this.userUniqueId = userUniqueId;
    }

    public Long getUserUniqueId(){
        return userUniqueId;
    }

    public void setRoleUniqueId(Long roleUniqueId){
        this.roleUniqueId = roleUniqueId;
    }

    public Long getRoleUniqueId(){
        return roleUniqueId;
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
