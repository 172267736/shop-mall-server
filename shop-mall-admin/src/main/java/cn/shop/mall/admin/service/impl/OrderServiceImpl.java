package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.service.OrderService;
import cn.shop.mall.center.dao.OrderAccountDao;
import cn.shop.mall.center.dao.OrderDao;
import cn.shop.mall.center.entity.OrderAccountEntity;
import cn.shop.mall.center.entity.OrderEntity;
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
    public ResponseVO list(Integer limit, Integer page) {
        Long count = orderDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<OrderEntity> list = orderDao.list(limit, offset);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }

    @Override
    public ResponseVO getById(Long id) {
        List<OrderAccountEntity> accountList = orderAccountDao.listByOrderId(id);
        OrderEntity orderEntity = orderDao.getById(id);
        orderEntity.setAccountList(accountList);
        return ResponseVO.SUCCESS(orderEntity);
    }

}
