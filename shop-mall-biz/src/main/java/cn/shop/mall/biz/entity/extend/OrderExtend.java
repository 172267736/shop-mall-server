package cn.shop.mall.biz.entity.extend;

import cn.shop.mall.biz.entity.OrderAccountEntity;

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
