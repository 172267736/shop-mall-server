package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.service.OrderService;
import cn.shop.mall.biz.dao.OrderAccountDao;
import cn.shop.mall.biz.dao.OrderDao;
import cn.shop.mall.biz.entity.OrderAccountEntity;
import cn.shop.mall.biz.entity.OrderEntity;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderAccountDao orderAccountDao;

    @Override
    public ResponseVO list() {
        Long count = orderDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<OrderEntity> list = orderDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }

    @Override
    public ResponseVO getById(Long id) {
        List<OrderAccountEntity> accountList = orderAccountDao.listByOrderId(id);
        OrderEntity orderEntity = orderDao.getById(id);
        orderEntity.setAccountList(accountList);
        return ResponseVO.SUCCESS(orderEntity);
    }

}
