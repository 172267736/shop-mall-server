package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加或者编辑菜单")
public class MenuParam {

    @ApiModelProperty(value = "主键自增")
    private Long uniqueId;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "父编号")
    private Long parentUniqueId;

    @ApiModelProperty(value = "菜单类型（1:根菜单;2:子菜单;3:权限接口;）")
    private Integer menuType;

    @ApiModelProperty(value = "路径")
    private String menuUrl;

    @ApiModelProperty(value = "排序号")
    private Integer sortNumber;

    @ApiModelProperty(value = "图标")
    private String icon;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentUniqueId() {
        return parentUniqueId;
    }

    public void setParentUniqueId(Long parentUniqueId) {
        this.parentUniqueId = parentUniqueId;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
