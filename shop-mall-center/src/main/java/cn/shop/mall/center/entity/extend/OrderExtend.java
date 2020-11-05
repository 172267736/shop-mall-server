package cn.shop.mall.center.entity.extend;

import cn.shop.mall.center.entity.OrderAccountEntity;

import java.util.List;

public class OrderExtend {

    private List<OrderAccountEntity> accountList;

    public List<OrderAccountEntity> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<OrderAccountEntity> accountList) {
        this.accountList = accountList;
    }
}
