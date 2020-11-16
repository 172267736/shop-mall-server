package cn.shop.mall.admin.model;

public class GoodsSkuParam {

    private Long uniqueId;

    private String bindProperty;

    private Integer goodsStock;

    private String smallImg;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getBindProperty() {
        return bindProperty;
    }

    public void setBindProperty(String bindProperty) {
        this.bindProperty = bindProperty;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

}
