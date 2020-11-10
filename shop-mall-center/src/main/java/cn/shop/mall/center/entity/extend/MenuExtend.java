package cn.shop.mall.center.entity.extend;

import cn.shop.mall.center.entity.MenuEntity;

import java.util.List;

/**
 * 菜单表
 */
public class MenuExtend {

    private String name;

    private String parentMenuName;

    private List<MenuEntity> child;

    public List<MenuEntity> getChild() {
        return child;
    }

    public void setChild(List<MenuEntity> child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }
}
