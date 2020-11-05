package cn.shop.mall.biz.entity;

import cn.shop.mall.biz.entity.extend.MenuExtend;

import java.util.Date;

/**
 * 菜单表
 */
public class MenuEntity extends MenuExtend {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 父编号
     */
    private Long parentUniqueId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 菜单类型（1：菜单；2：功能；3：按钮/接口）
     */
    private Integer menuType;

    /**
     * 排序号
     */
    private Integer sortNumber;

    /**
     * 图标
     */
    private String icon;

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

    public void setParentUniqueId(Long parentUniqueId) {
        this.parentUniqueId = parentUniqueId;
    }

    public Long getParentUniqueId() {
        return parentUniqueId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
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
