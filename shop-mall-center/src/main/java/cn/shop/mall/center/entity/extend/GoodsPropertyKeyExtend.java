package cn.shop.mall.center.entity.extend;

import cn.shop.mall.center.entity.GoodsPropertyValueEntity;

import java.util.List;

public class GoodsPropertyKeyExtend {

    private List<GoodsPropertyValueEntity> propertyValueList;

    public List<GoodsPropertyValueEntity> getPropertyValueList() {
        return propertyValueList;
    }

    public void setPropertyValueList(List<GoodsPropertyValueEntity> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }
}
