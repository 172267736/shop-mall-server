package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.service.OrderService;
import cn.shop.mall.center.dao.GoodsDao;
import cn.shop.mall.center.dao.GoodsSkuDao;
import cn.shop.mall.center.dao.OrderAccountDao;
import cn.shop.mall.center.dao.OrderDao;
import cn.shop.mall.center.entity.GoodsSkuEntity;
import cn.shop.mall.center.entity.OrderAccountEntity;
import cn.shop.mall.center.entity.OrderEntity;
import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.util.CommontUtil;
import cn.shop.mall.common.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 订单业务类型
 * Created by LSY on 2020/11/15.
 */
@Service
public class OrderServiceImp implements OrderService {

    private static Object LOCK = new Object();

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderAccountDao orderAccountDao;

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    /**
     * 我的订单
     * @param orderEntity 订单实体
     * @param page  当前页
     * @param limit 每页记录数
     * @return 订单列表
     */
    @Override
    public ResponseVO myOrder(OrderEntity orderEntity, Integer limit, Integer page) {
        if (Objects.isNull(CurrentAuthorization.getUniqueId())) {
            throw new BizException("用户ID为空");
        }
        Integer offset = (page - 1) * limit;
        List<OrderEntity> orderList = orderDao.list(orderEntity, limit, offset);
        return ResponseVO.SUCCESS(orderList);
    }

    /**
     * 获取订单详情
     * @param orderId 订单ID
     * @return 订单详情列表
     */
    @Override
    public ResponseVO myOrderDetail(Long orderId) {
        if (Objects.isNull(CurrentAuthorization.getUniqueId())) {
            throw new BizException("订单ID为空");
        }
        List<OrderAccountEntity> orderAccountList = orderAccountDao.listByOrderId(orderId);

        return ResponseVO.SUCCESS(orderAccountList);
    }


    /**
     * 创建订单
     *
     * @param orderEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = BizException.class)
    public ResponseVO createOrder(OrderEntity orderEntity) {
        if (Objects.isNull(CurrentAuthorization.getUniqueId())) {
            throw new BizException("用户ID为空");
        }
        orderEntity.setPayUserUniqueId(CurrentAuthorization.getUniqueId());
        orderEntity.setCreateDate(new Date());
        orderEntity.setUpdateDate(new Date());
        orderEntity.setOrderNumber(CommontUtil.getOrderSn());

        //保存订单
        orderDao.save(orderEntity);

        List<OrderAccountEntity> orderDetailList = orderEntity.getAccountList();
        orderDetailList.forEach(orderDetail -> {
            //查看该商品库存是够
            synchronized (LOCK){
                List<GoodsSkuEntity> goodsSkuList = goodsSkuDao.listByGoodsId(orderDetail.getGoodsUniqueId());
                if(goodsSkuList.isEmpty() || goodsSkuList.get(0).getGoodsStock() < orderDetail.getBuyNumber()){
                    //事务回滚
                    throw new BizException("库存不足");
                }else{
                    //修改库存
                    GoodsSkuEntity goodsSku = new GoodsSkuEntity();
                    goodsSku.setGoodsStock(goodsSku.getGoodsStock() - orderDetail.getBuyNumber());
                    goodsSku.setGoodsUniqueId(orderDetail.getGoodsUniqueId());
                    goodsSkuDao.updateStock(goodsSku);
                }
            }
            orderDetail.setOrderUniqueId(orderEntity.getUniqueId());
            orderDetail.setCreateDate(new Date());
            orderDetail.setUpdateDate(new Date());
        });

        orderAccountDao.saveBatch(orderDetailList);
        //保存订单详情
        return ResponseVO.SUCCESS();
    }
}
