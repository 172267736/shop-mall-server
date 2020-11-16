package cn.shop.mall.center.entity;

import cn.shop.mall.center.entity.extend.GoodsExtend;

import java.util.Date;

/**
 * 商品表
 */
public class GoodsEntity extends GoodsExtend {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 大图集合
     */
    private String bigImgs;

    /**
     * 详情
     */
    private String goodsContent;

    /**
     * 商品视频
     */
    private String goodsVideo;

    /**
     * 商品说明
     */
    private String goodsDescription;

    /**
     * 所属分类编号
     */
    private String belongClassifyIds;

    /**
     * 商品标签
     */
    private String goodsTags;

    /**
     * 置顶序号
     */
    private Integer topSort;

    /**
     * 商品原价（单位：元）
     */
    private Double originalPrice;

    /**
     * 商品现价（单位：元）
     */
    private Double currentPrice;

    private String stockUnit;

    /**
     * 是否上架（0：否；1：是）
     */
    private Integer status;

    private String goodsBrand;

    private String goodsBrandLogo;

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

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setBigImgs(String bigImgs) {
        this.bigImgs = bigImgs;
    }

    public String getBigImgs() {
        return bigImgs;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsVideo(String goodsVideo) {
        this.goodsVideo = goodsVideo;
    }

    public String getGoodsVideo() {
        return goodsVideo;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setBelongClassifyIds(String belongClassifyIds) {
        this.belongClassifyIds = belongClassifyIds;
    }

    public String getBelongClassifyIds() {
        return belongClassifyIds;
    }

    public void setGoodsTags(String goodsTags) {
        this.goodsTags = goodsTags;
    }

    public String getGoodsTags() {
        return goodsTags;
    }

    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }

    public Integer getTopSort() {
        return topSort;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsBrandLogo() {
        return goodsBrandLogo;
    }

    public void setGoodsBrandLogo(String goodsBrandLogo) {
        this.goodsBrandLogo = goodsBrandLogo;
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

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }
}
