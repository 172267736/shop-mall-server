package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.service.GoodsService;
import cn.shop.mall.center.dao.GoodsClassifyDao;
import cn.shop.mall.center.dao.GoodsDao;
import cn.shop.mall.center.entity.GoodsClassifyEntity;
import cn.shop.mall.center.entity.GoodsEntity;
import cn.shop.mall.common.model.PageDto;
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

    @Resource
    private GoodsClassifyDao goodsClassifyDao;

    @Resource
    private GoodsDao goodsDao;

    @Override
    public PageDto<List<GoodsEntity>> queryGoods(GoodsEntity goodsEntity, Integer limit, Integer page) {
        Integer offset = (page - 1) * limit;
        List<GoodsEntity> goodsList = goodsDao.querGoods(goodsEntity, offset, limit);
        Long count = goodsDao.count(null, null, goodsEntity.getGoodsName(), goodsEntity.getBelongClassifyId());
        return new PageDto(goodsList, count, limit);
    }

    @Override
    public GoodsEntity queryGoodDetail(Long goodId) {
        return goodsDao.getById(goodId);
    }

    @Override
    public GoodsClassifyEntity queryClassfiy(Long parentId) {
        if (StringUtils.isEmpty(parentId)) {
            parentId = 0L;
        }
        return goodsClassifyDao.getByParentId(parentId);
    }
}
