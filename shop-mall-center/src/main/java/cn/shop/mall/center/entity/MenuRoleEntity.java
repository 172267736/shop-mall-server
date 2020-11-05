package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 菜单角色表
 */
public class MenuRoleEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 菜单编号
     */
    private Long menuUniqueId;

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

    public void setMenuUniqueId(Long menuUniqueId){
        this.menuUniqueId = menuUniqueId;
    }

    public Long getMenuUniqueId(){
        return menuUniqueId;
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
