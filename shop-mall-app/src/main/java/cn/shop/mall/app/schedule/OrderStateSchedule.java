package cn.shop.mall.app.schedule;

import cn.shop.mall.center.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by LSY on 2020/11/23.
 */
@Component
public class OrderStateSchedule {

    @Autowired
    private OrderDao orderDao;

    /**
     * 每分钟检查订单状态是否过期
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void checkOrderExpire() {
        orderDao.updateOrderExpireState();
    }
}
