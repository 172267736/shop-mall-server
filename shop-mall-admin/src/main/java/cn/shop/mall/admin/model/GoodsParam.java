package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("添加或者编辑商品")
public class GoodsParam {

    /**
     * 主键自增
     */
    @ApiModelProperty(value = "主键自增")
    private Long uniqueId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    /**
     * 大图集合
     */
    @ApiModelProperty(value = "大图集合")
    private String bigImgs;

    /**
     * 详情
     */
    @ApiModelProperty(value = "详情")
    private String goodsContent;

    /**
     * 商品视频
     */
    @ApiModelProperty(value = "商品视频")
    private String goodsVideo;

    /**
     * 商品说明
     */
    @ApiModelProperty(value = "商品说明")
    private String goodsDescription;

    /**
     * 所属分类编号
     */
    @ApiModelProperty(value = "所属分类编号")
    private String belongClassifyIds;

    /**
     * 商品标签
     */
    @ApiModelProperty(value = "商品标签")
    private String goodsTags;

    /**
     * 置顶序号
     */
    @ApiModelProperty(value = "置顶序号")
    private Integer topSort;

    /**
     * 商品原价（单位：元）
     */
    @ApiModelProperty(value = "商品原价（单位：元）")
    private Double originalPrice;

    /**
     * 商品现价（单位：元）
     */
    @ApiModelProperty(value = "商品现价（单位：元）")
    private Double currentPrice;

    @ApiModelProperty(value = "库存单位")
    private String stockUnit;

    /**
     * 是否上架（0：否；1：是）
     */
    @ApiModelProperty(value = "是否上架（0：否；1：是）")
    private Integer status;

    @ApiModelProperty(value = "商品属性信息")
    private List<GoodsPropertyParam> goodsPropertyList;

    @ApiModelProperty(value = "商品库存信息")
    private List<GoodsSkuParam> goodsSkuParamList;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBigImgs() {
        return bigImgs;
    }

    public void setBigImgs(String bigImgs) {
        this.bigImgs = bigImgs;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public String getGoodsVideo() {
        return goodsVideo;
    }

    public void setGoodsVideo(String goodsVideo) {
        this.goodsVideo = goodsVideo;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getBelongClassifyIds() {
        return belongClassifyIds;
    }

    public void setBelongClassifyIds(String belongClassifyIds) {
        this.belongClassifyIds = belongClassifyIds;
    }

    public String getGoodsTags() {
        return goodsTags;
    }

    public void setGoodsTags(String goodsTags) {
        this.goodsTags = goodsTags;
    }

    public Integer getTopSort() {
        return topSort;
    }

    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GoodsPropertyParam> getGoodsPropertyList() {
        return goodsPropertyList;
    }

    public void setGoodsPropertyList(List<GoodsPropertyParam> goodsPropertyList) {
        this.goodsPropertyList = goodsPropertyList;
    }

    public List<GoodsSkuParam> getGoodsSkuParamList() {
        return goodsSkuParamList;
    }

    public void setGoodsSkuParamList(List<GoodsSkuParam> goodsSkuParamList) {
        this.goodsSkuParamList = goodsSkuParamList;
    }
}
