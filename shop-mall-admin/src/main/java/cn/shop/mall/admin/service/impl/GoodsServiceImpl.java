package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.admin.service.GoodsService;
import cn.shop.mall.biz.dao.GoodsClassifyDao;
import cn.shop.mall.biz.dao.GoodsDao;
import cn.shop.mall.biz.dao.GoodsPropertyKeyDao;
import cn.shop.mall.biz.dao.GoodsPropertyValueDao;
import cn.shop.mall.biz.dao.GoodsSkuDao;
import cn.shop.mall.biz.entity.GoodsClassifyEntity;
import cn.shop.mall.biz.entity.GoodsEntity;
import cn.shop.mall.biz.entity.GoodsPropertyKeyEntity;
import cn.shop.mall.biz.entity.GoodsPropertyValueEntity;
import cn.shop.mall.biz.entity.GoodsSkuEntity;
import cn.shop.mall.common.enums.BooleanEnum;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsClassifyDao goodsClassifyDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsPropertyKeyDao goodsPropertyKeyDao;

    @Autowired
    private GoodsPropertyValueDao goodsPropertyValueDao;

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    @Override
    public ResponseVO list() {
        Long count = goodsDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<GoodsEntity> list = goodsDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }

    @Override
    public ResponseVO listType() {
        Long count = goodsClassifyDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<GoodsClassifyEntity> list = goodsClassifyDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }

    @Override
    public ResponseVO saveType(String classifyName, Long classifyParentId, String classifyIcon, String classifyDescription) {
        GoodsClassifyEntity goodsClassifyEntity = new GoodsClassifyEntity();
        goodsClassifyEntity.setClassifyName(classifyName);
        goodsClassifyEntity.setClassifyDescription(classifyDescription);
        goodsClassifyEntity.setClassifyParentId(classifyParentId);
        goodsClassifyEntity.setClassifyIcon(classifyIcon);
        goodsClassifyDao.save(goodsClassifyEntity);
        return ResponseVO.SUCCESS();
    }

    @Transactional
    @Override
    public ResponseVO save(GoodsParam goodsParam) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setBelongClassifyIds(goodsParam.getBelongClassifyIds());
        goodsEntity.setBigImgs(goodsParam.getBigImgs());
        goodsEntity.setCurrentPrice(goodsParam.getCurrentPrice());
        goodsEntity.setGoodsContent(goodsParam.getGoodsContent());
        goodsEntity.setGoodsDescription(goodsParam.getGoodsDescription());
        goodsEntity.setGoodsName(goodsParam.getGoodsName());
        goodsEntity.setGoodsTags(goodsParam.getGoodsTags());
        goodsEntity.setGoodsVideo(goodsParam.getGoodsVideo());
        goodsEntity.setOriginalPrice(goodsParam.getOriginalPrice());
        goodsEntity.setStatus(goodsParam.getStatus());
        goodsEntity.setStockUnit(goodsParam.getStockUnit());
        goodsEntity.setTopSort(goodsEntity.getTopSort());
        goodsDao.save(goodsEntity);
        Long goodsId = goodsEntity.getUniqueId();
        Map<String, Double> priceMap = Maps.newHashMap();
        goodsParam.getGoodsPropertyList().forEach(key -> {
            GoodsPropertyKeyEntity propertyKey = new GoodsPropertyKeyEntity();
            propertyKey.setGoodsUniqueId(goodsId);
            propertyKey.setPropertyKey(key.getPropertyKey());
            propertyKey.setPropertyName(key.getPropertyName());
            propertyKey.setPropertyKeySort(key.getPropertyKeySort());
            goodsPropertyKeyDao.save(propertyKey);
            key.getValueList().forEach(value -> {
                GoodsPropertyValueEntity propertyValue = new GoodsPropertyValueEntity();
                propertyValue.setGoodsPropertyKeyUniqueId(propertyKey.getUniqueId());
                propertyValue.setPropertyValue(value.getPropertyValue());
                propertyValue.setValueCost(value.getValueCost());
                propertyValue.setPropertyValueSort(value.getPropertyValueSort());
                propertyValue.setValueFlag(value.getValueFlag());
                goodsPropertyValueDao.save(propertyValue);
                priceMap.put(value.getValueFlag(), value.getValueCost());
            });
        });
        Double price = goodsParam.getCurrentPrice();
        List<GoodsSkuEntity> skuList = Lists.newArrayList();
        goodsParam.getGoodsSkuParamList().forEach(sku -> {
            GoodsSkuEntity goodsSku = new GoodsSkuEntity();
            goodsSku.setGoodsStock(sku.getGoodsStock());
            goodsSku.setGoodsUniqueId(goodsId);
            goodsSku.setGoodsStock(sku.getGoodsStock());
            goodsSku.setSkuFlag(sku.getSkuFlag());
            goodsSku.setSmallImg(sku.getSmallImg());
            String[] flags = sku.getSkuFlag().split("_");
            Double skuPrice = 0D;
            for (String flag : Lists.newArrayList(flags)) {
                skuPrice += priceMap.get(flag);
            }
            goodsSku.setPrice(price + skuPrice);
            skuList.add(goodsSku);
        });
        goodsSkuDao.batchSave(skuList);
        return ResponseVO.SUCCESS();
    }

    @Transactional
    @Override
    public ResponseVO update(GoodsParam goodsParam) {
        GoodsEntity goodsEntity = goodsDao.getById(goodsParam.getUniqueId());
        if (goodsEntity == null) {
            return ResponseVO.FAIL("商品不存在");
        }
        if (goodsEntity.getStatus().equals(BooleanEnum.是.getCode())) {
            return ResponseVO.FAIL("上架商品不可编辑");
        }
        Double newPrice = goodsParam.getCurrentPrice();
        Double oldPrice = goodsEntity.getCurrentPrice();
        if (newPrice != null && !newPrice.equals(oldPrice)) {
            List<GoodsSkuEntity> skuList = goodsSkuDao.listByGoodsId(goodsEntity.getUniqueId());
            skuList.forEach(sku -> sku.setPrice(sku.getPrice() - oldPrice + newPrice));
            goodsSkuDao.batchUpdate(skuList);
            goodsEntity.setGoodsContent(goodsParam.getGoodsContent());
        }
        goodsEntity.setGoodsTags(goodsParam.getGoodsTags());
        goodsEntity.setGoodsVideo(goodsParam.getGoodsVideo());
        goodsEntity.setOriginalPrice(goodsParam.getOriginalPrice());
        goodsEntity.setStockUnit(goodsParam.getStockUnit());
        goodsEntity.setTopSort(goodsEntity.getTopSort());
        goodsEntity.setBelongClassifyIds(goodsParam.getBelongClassifyIds());
        goodsEntity.setBigImgs(goodsParam.getBigImgs());
        goodsEntity.setCurrentPrice(goodsParam.getCurrentPrice());
        goodsEntity.setGoodsDescription(goodsParam.getGoodsDescription());
        goodsEntity.setGoodsName(goodsParam.getGoodsName());
        goodsDao.save(goodsEntity);
        return ResponseVO.SUCCESS();
    }
}
