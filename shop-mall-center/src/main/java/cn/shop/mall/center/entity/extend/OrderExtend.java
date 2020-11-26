package cn.shop.mall.center.entity.extend;

import cn.shop.mall.center.entity.OrderAccountEntity;
import cn.shop.mall.common.model.PageBean;

import java.util.List;

public class OrderExtend extends PageBean{

    private List<OrderAccountEntity> accountList;

    public List<OrderAccountEntity> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<OrderAccountEntity> accountList) {
        this.accountList = accountList;
    }
}
