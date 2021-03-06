package cn.shop.mall.center.entity.extend;

import cn.shop.mall.center.entity.GoodsPropertyKeyEntity;
import cn.shop.mall.common.model.PageBean;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * 菜单表
 */
public class GoodsExtend extends PageBean{

    private String belongClassifyNames;

    private JSONArray belongClassifyIdList;

    private JSONArray bigImgList;

    private JSONArray goodsTagList;

    private List<GoodsPropertyKeyEntity> propertyKeyList;

    public JSONArray getBelongClassifyIdList() {
        return belongClassifyIdList;
    }

    /**
     * 库存数量
     */
    private Integer goodsStock;

    public void setBelongClassifyIdList(JSONArray belongClassifyIdList) {
        this.belongClassifyIdList = belongClassifyIdList;
    }

    public String getBelongClassifyNames() {
        return belongClassifyNames;
    }

    public void setBelongClassifyNames(String belongClassifyNames) {
        this.belongClassifyNames = belongClassifyNames;
    }

    public JSONArray getBigImgList() {
        return bigImgList;
    }

    public void setBigImgList(JSONArray bigImgList) {
        this.bigImgList = bigImgList;
    }

    public JSONArray getGoodsTagList() {
        return goodsTagList;
    }

    public void setGoodsTagList(JSONArray goodsTagList) {
        this.goodsTagList = goodsTagList;
    }

    public List<GoodsPropertyKeyEntity> getPropertyKeyList() {
        return propertyKeyList;
    }

    public void setPropertyKeyList(List<GoodsPropertyKeyEntity> propertyKeyList) {
        this.propertyKeyList = propertyKeyList;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }
}
