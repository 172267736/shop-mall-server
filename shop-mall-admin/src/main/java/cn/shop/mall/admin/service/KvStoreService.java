package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.KvStoreParam;
import cn.shop.mall.common.vo.ResponseVO;

import java.util.List;

public interface KvStoreService {

    ResponseVO save(KvStoreParam kvStoreParam);

    ResponseVO update(KvStoreParam kvStoreParam);

    ResponseVO delete(List<Long> ids);

    ResponseVO detail(Long id);

    ResponseVO list(String keyFlag, Integer limit, Integer page);

}
