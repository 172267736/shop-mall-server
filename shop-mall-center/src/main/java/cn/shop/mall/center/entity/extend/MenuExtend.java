package cn.shop.mall.center.entity.extend;

import cn.shop.mall.center.entity.MenuEntity;

import java.util.List;

/**
 * 菜单表
 */
public class MenuExtend {

    private List<MenuEntity> child;

    public List<MenuEntity> getChild() {
        return child;
    }

    public void setChild(List<MenuEntity> child) {
        this.child = child;
    }
}
