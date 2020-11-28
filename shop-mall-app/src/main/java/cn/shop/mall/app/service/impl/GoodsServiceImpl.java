package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.service.GoodsService;
import cn.shop.mall.center.dao.GoodsClassifyDao;
import cn.shop.mall.center.dao.GoodsDao;
import cn.shop.mall.center.entity.GoodsClassifyEntity;
import cn.shop.mall.center.entity.GoodsEntity;
import cn.shop.mall.common.model.PageDto;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品业务类
 * Created by LSY on 2020/11/16.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsClassifyDao goodsClassifyDao;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public PageDto<List<GoodsEntity>> queryGoods(GoodsEntity goodsEntity) {
        goodsEntity.setOffset(goodsEntity.getPage(), goodsEntity.getLimit());
        List<GoodsEntity> goodsList = goodsDao.querGoods(goodsEntity);
        //字符串转换JSONArray 此处应该用TypeHanlder
        goodsList.forEach(goods ->{
            setGoodsInfo(goods);
        });

        Long count = goodsDao.count(1, null, goodsEntity.getGoodsName(), goodsEntity.getBelongClassifyId());
        return new PageDto(goodsList, count, goodsEntity.getLimit());
    }

    @Override
    public GoodsEntity queryGoodDetail(Long goodId) {
        GoodsEntity goods = goodsDao.getById(goodId);
        setGoodsInfo(goods);
        return goods;
    }

    @Override
    public List<GoodsClassifyEntity> queryClassfiy(Long parentId) {
        if (StringUtils.isEmpty(parentId)) {
            parentId = 0L;
        }
        return goodsClassifyDao.getByParentId(parentId);
    }

    /**
     * 设置商品属性
     * @param goods 商品实体
     */
    public void setGoodsInfo(GoodsEntity goods){
        goods.setGoodsTagList(JSON.parseArray(goods.getGoodsTags()));
        goods.setBigImgList(JSON.parseArray(goods.getBigImgs()));
        goods.setGoodsStock(goods.getGoodsStock()==null?0:goods.getGoodsStock());
        goods.setBelongClassifyIdList(JSON.parseArray(goods.getBelongClassifyIds()));
    }

}
