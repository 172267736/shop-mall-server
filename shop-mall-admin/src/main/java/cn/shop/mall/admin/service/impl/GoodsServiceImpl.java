package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.event.EventTrack;
import cn.shop.mall.admin.model.GoodsClassifyParam;
import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.admin.model.GoodsSkuParam;
import cn.shop.mall.admin.service.GoodsService;
import cn.shop.mall.center.dao.GoodsClassifyDao;
import cn.shop.mall.center.dao.GoodsDao;
import cn.shop.mall.center.dao.GoodsPropertyKeyDao;
import cn.shop.mall.center.dao.GoodsPropertyValueDao;
import cn.shop.mall.center.dao.GoodsSkuDao;
import cn.shop.mall.center.entity.GoodsClassifyEntity;
import cn.shop.mall.center.entity.GoodsEntity;
import cn.shop.mall.center.entity.GoodsPropertyKeyEntity;
import cn.shop.mall.center.entity.GoodsPropertyValueEntity;
import cn.shop.mall.center.entity.GoodsSkuEntity;
import cn.shop.mall.common.enums.BooleanEnum;
import cn.shop.mall.common.enums.EventTrackEnum;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    public ResponseVO listType(Integer limit, Integer page, String classifyName) {
        Long count = goodsClassifyDao.count(classifyName);
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<GoodsClassifyEntity> list = goodsClassifyDao.list(limit, offset, classifyName);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }

    @Override
    public ResponseVO listAllType() {
        return ResponseVO.SUCCESS(goodsClassifyDao.listAll());
    }

    @EventTrack(EventTrackEnum.编辑商品分类)
    @Override
    public ResponseVO updateType(GoodsClassifyParam goodsClassifyParam) {
        GoodsClassifyEntity goodsClassifyEntity = goodsClassifyDao.getById(goodsClassifyParam.getUniqueId());
        if (goodsClassifyEntity == null) {
            return ResponseVO.FAIL("分类不存在");
        }
        goodsClassifyEntity.setClassifyDescription(goodsClassifyParam.getClassifyDescription());
        goodsClassifyEntity.setClassifyIcon(goodsClassifyParam.getClassifyIcon());
        goodsClassifyEntity.setClassifyName(goodsClassifyParam.getClassifyName());
        goodsClassifyDao.update(goodsClassifyEntity);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO detailType(Long id) {
        return ResponseVO.SUCCESS(goodsClassifyDao.getById(id));
    }

    @EventTrack(value = EventTrackEnum.新增商品分类)
    @Override
    public ResponseVO saveType(GoodsClassifyParam goodsClassifyParam) {
        GoodsClassifyEntity goodsClassifyEntity = new GoodsClassifyEntity();
        goodsClassifyEntity.setClassifyName(goodsClassifyParam.getClassifyName());
        goodsClassifyEntity.setClassifyDescription(goodsClassifyParam.getClassifyDescription());
        goodsClassifyEntity.setClassifyParentId(goodsClassifyParam.getClassifyParentId());
        goodsClassifyEntity.setClassifyIcon(goodsClassifyParam.getClassifyIcon());
        goodsClassifyDao.save(goodsClassifyEntity);
        return ResponseVO.SUCCESS();
    }


    @Override
    public ResponseVO list(Integer limit, Integer page, Integer status, String goodsTag, String goodsName, Long belongClassifyId) {
        Long count = goodsDao.count(status, goodsTag, goodsName, belongClassifyId);
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<GoodsEntity> list = goodsDao.list(limit, offset, status, goodsTag, goodsName, belongClassifyId);
        List<GoodsClassifyEntity> goodsClassifyList = goodsClassifyDao.listAll();
        Map<Long, GoodsClassifyEntity> goodsClassifMap = Maps.uniqueIndex(goodsClassifyList, GoodsClassifyEntity::getUniqueId);
        list.parallelStream().forEach(goodsEntity -> {
            JSONArray ids = JSONArray.parseArray(goodsEntity.getBelongClassifyIds());
            if (!CollectionUtils.isEmpty(ids)) {
                JSONArray names = new JSONArray();
                ids.forEach(id -> {
                    GoodsClassifyEntity classifyEntity = goodsClassifMap.get(Long.valueOf(id.toString()));
                    if (classifyEntity != null) {
                        names.add(classifyEntity.getClassifyName());
                    }
                });
                goodsEntity.setBelongClassifyNames(names.toJSONString());
            }
        });
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }

    @Override
    public ResponseVO detail(Long id) {
        GoodsEntity goodsEntity = goodsDao.getById(id);
        goodsEntity.setGoodsTagList(JSONArray.parseArray(goodsEntity.getGoodsTags()));
        goodsEntity.setBigImgList(JSONArray.parseArray(goodsEntity.getBigImgs()));
        goodsEntity.setBelongClassifyIdList(JSONArray.parseArray(goodsEntity.getBelongClassifyIds()));
        return ResponseVO.SUCCESS(goodsEntity);
    }

    @Override
    public ResponseVO listPropertyByGoodsId(Long goodsId) {
        List<GoodsPropertyKeyEntity> keyList = goodsPropertyKeyDao.listByGoodsId(goodsId);
        List<Long> keyIds = Lists.transform(keyList, GoodsPropertyKeyEntity::getUniqueId);
        List<GoodsPropertyValueEntity> valueList = goodsPropertyValueDao.listByKeyIds(keyIds);
        JSONArray result = new JSONArray();
        keyList.forEach(key -> {
            JSONObject object = new JSONObject();
            object.put("uniqueId", key.getUniqueId());
            object.put("propertyKey", key.getPropertyKey());
            object.put("goodsPropertyKeyUniqueId", 0L);
            object.put("propertyName", key.getPropertyName());
            object.put("sortNumber", key.getPropertyKeySort());
            result.add(object);
        });
        valueList.forEach(value -> {
            JSONObject object = new JSONObject();
            object.put("uniqueId", value.getUniqueId());
            object.put("goodsPropertyKeyUniqueId", value.getGoodsPropertyKeyUniqueId());
            object.put("propertyName", value.getPropertyValue());
            object.put("valueCost", value.getValueCost());
            object.put("sortNumber", value.getPropertyValueSort());
            result.add(object);
        });
        return ResponseVO.SUCCESS(result);
    }

    @Override
    public ResponseVO listSkuByGoodsId(Long goodsId) {
        List<GoodsSkuEntity> skuList = goodsSkuDao.listByGoodsId(goodsId);
        List<GoodsPropertyKeyEntity> keyList = goodsPropertyKeyDao.listByGoodsId(goodsId);
        Map<String, GoodsPropertyKeyEntity> keyEntityMap = Maps.uniqueIndex(keyList, GoodsPropertyKeyEntity::getPropertyKey);
        List<Long> keyIds = Lists.transform(keyList, GoodsPropertyKeyEntity::getUniqueId);
        List<GoodsPropertyValueEntity> valueList = goodsPropertyValueDao.listByKeyIds(keyIds);
        Map<String, GoodsPropertyValueEntity> valueEntityMap = Maps.uniqueIndex(valueList, GoodsPropertyValueEntity::getValueFlag);
        JSONArray result = new JSONArray();
        skuList.forEach(sku -> {
            JSONObject object = new JSONObject();
            object.put("uniqueId", sku.getUniqueId());
            object.put("goodsStock", sku.getGoodsStock());
            object.put("smallImg", sku.getSmallImg());
            object.put("price", sku.getPrice());
            JSONObject propertyJson = JSONObject.parseObject(sku.getBindProperty());
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : propertyJson.entrySet()) {
                stringBuilder.append("[")
                        .append(keyEntityMap.get(entry.getKey().toString()).getPropertyName())
                        .append(":")
                        .append(valueEntityMap.get(entry.getValue().toString()).getPropertyValue())
                        .append("]");
            }
            object.put("property", stringBuilder);
            result.add(object);
        });
        return ResponseVO.SUCCESS(result);
    }

    @EventTrack(value = EventTrackEnum.新增商品)
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
            goodsSku.setBindProperty(sku.getBindProperty());
            goodsSku.setSmallImg(sku.getSmallImg());
            JSONObject bindPropertyJson = JSONObject.parseObject(sku.getBindProperty());
            Double skuPrice = 0D;
            for (Map.Entry entry : bindPropertyJson.entrySet()) {
                skuPrice += Double.valueOf(priceMap.get(entry.getValue().toString()).toString());
            }
            goodsSku.setPrice(price + skuPrice);
            skuList.add(goodsSku);
        });
        goodsSkuDao.batchSave(skuList);
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.上下架商品)
    @Transactional
    @Override
    public ResponseVO updateStatus(GoodsParam goodsParam) {
        GoodsEntity goodsEntity = goodsDao.getById(goodsParam.getUniqueId());
        if (goodsEntity == null) {
            return ResponseVO.FAIL("商品不存在");
        }
        goodsEntity.setStatus(goodsParam.getStatus());
        goodsDao.update(goodsEntity);
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.更新商品价格)
    @Transactional
    @Override
    public ResponseVO updatePrice(GoodsParam goodsParam) {
        GoodsEntity goodsEntity = goodsDao.getById(goodsParam.getUniqueId());
        if (goodsEntity == null) {
            return ResponseVO.FAIL("商品不存在");
        }
        if (goodsEntity.getStatus().equals(BooleanEnum.是.getCode())) {
            return ResponseVO.FAIL("请先下架");
        }
        Double oldPrice = goodsEntity.getCurrentPrice();
        Double newPrice = goodsParam.getCurrentPrice();
        goodsEntity.setCurrentPrice(newPrice);
        goodsDao.update(goodsEntity);
        Double priceDif = newPrice - oldPrice;
        List<GoodsSkuEntity> skuList = goodsSkuDao.listByGoodsId(goodsEntity.getUniqueId());
        skuList.forEach(sku -> sku.setPrice(sku.getPrice() + priceDif));
        goodsSkuDao.batchUpdate(skuList);
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.更新商品库存)
    @Transactional
    @Override
    public ResponseVO updateSku(GoodsSkuParam goodsSkuParam) {
        GoodsSkuEntity goodsSkuEntity = new GoodsSkuEntity();
        goodsSkuEntity.setUniqueId(goodsSkuParam.getUniqueId());
        goodsSkuEntity.setGoodsStock(goodsSkuParam.getGoodsStock());
        goodsSkuDao.update(goodsSkuEntity);
        return ResponseVO.SUCCESS();
    }
}
