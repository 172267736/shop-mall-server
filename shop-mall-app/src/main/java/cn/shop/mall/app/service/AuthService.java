package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.UserAppEntity;

/**
 * Created by LSY on 2020/12/14.
 */
public interface AuthService {


    void login(String code);

    void register(UserAppEntity userAppEntity);

}
