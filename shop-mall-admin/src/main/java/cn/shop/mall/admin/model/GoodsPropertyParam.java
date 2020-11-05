package cn.shop.mall.admin.model;

import java.util.List;

public class GoodsPropertyParam {

    private String propertyKey;

    private String propertyName;

    private Integer propertyKeySort;

    private List<GoodsPropertyValueParam> valueList;

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getPropertyKeySort() {
        return propertyKeySort;
    }

    public void setPropertyKeySort(Integer propertyKeySort) {
        this.propertyKeySort = propertyKeySort;
    }

    public List<GoodsPropertyValueParam> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsPropertyValueParam> valueList) {
        this.valueList = valueList;
    }
}
