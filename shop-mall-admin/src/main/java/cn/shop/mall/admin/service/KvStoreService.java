package cn.shop.mall.admin.service;

import cn.shop.mall.common.vo.ResponseVO;

public interface KvStoreService {

    ResponseVO save(String key, String firstName, String lastName, String value, String keyDescription);

    ResponseVO update(Long id, String firstName, String lastName, String value, String keyDescription);

    ResponseVO delete(Long id);

    ResponseVO list();

}
