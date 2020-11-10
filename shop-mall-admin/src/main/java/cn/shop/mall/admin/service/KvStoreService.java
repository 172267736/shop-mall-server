package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.KvStoreParam;
import cn.shop.mall.common.vo.ResponseVO;

public interface KvStoreService {

    ResponseVO save(KvStoreParam kvStoreParam);

    ResponseVO update(KvStoreParam kvStoreParam);

    ResponseVO delete(Long id);

    ResponseVO list(Integer limit, Integer page);

}
