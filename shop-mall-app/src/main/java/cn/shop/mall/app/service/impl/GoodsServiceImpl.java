package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.service.GoodsService;
import cn.shop.mall.center.dao.GoodsClassifyDao;
import cn.shop.mall.center.dao.GoodsDao;
import cn.shop.mall.center.entity.GoodsClassifyEntity;
import cn.shop.mall.center.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<GoodsEntity> queryGoods(GoodsEntity goodsEntity) {
        return null;
    }

    @Override
    public GoodsEntity queryGoodDetail(Long goodId) {
        return null;
    }

    @Override
    public GoodsClassifyEntity queryClassfiy(Long parentId) {
        if(StringUtils.isEmpty(parentId)){
            parentId = 0L;
        }
        return goodsClassifyDao.getByParentId(parentId);
    }
}
