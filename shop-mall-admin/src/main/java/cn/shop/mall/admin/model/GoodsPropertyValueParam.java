package cn.shop.mall.admin.model;

public class GoodsPropertyValueParam {

    private String valueFlag;

    private String propertyValue;

    private Double valueCost;

    private Integer propertyValueSort;

    public String getValueFlag() {
        return valueFlag;
    }

    public void setValueFlag(String valueFlag) {
        this.valueFlag = valueFlag;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Double getValueCost() {
        return valueCost;
    }

    public void setValueCost(Double valueCost) {
        this.valueCost = valueCost;
    }

    public Integer getPropertyValueSort() {
        return propertyValueSort;
    }

    public void setPropertyValueSort(Integer propertyValueSort) {
        this.propertyValueSort = propertyValueSort;
    }
}
