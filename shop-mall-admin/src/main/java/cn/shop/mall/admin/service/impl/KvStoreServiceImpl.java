package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.model.KvStoreParam;
import cn.shop.mall.admin.service.KvStoreService;
import cn.shop.mall.center.dao.KvStoreDao;
import cn.shop.mall.center.entity.KvStoreEntity;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KvStoreServiceImpl implements KvStoreService {

    @Autowired
    private KvStoreDao kvStoreDao;

    @Override
    public ResponseVO save(KvStoreParam kvStoreParam) {
        if (kvStoreDao.getByKey(kvStoreParam.getKey()) != null) {
            return ResponseVO.FAIL("当前键值对已经存在");
        }
        KvStoreEntity kvStoreEntity = new KvStoreEntity();
        kvStoreEntity.setKey(kvStoreParam.getKey());
        kvStoreEntity.setFirstName(kvStoreParam.getFirstName());
        kvStoreEntity.setLastName(kvStoreParam.getLastName());
        kvStoreEntity.setValue(kvStoreParam.getValue());
        kvStoreEntity.setKeyDescription(kvStoreParam.getKeyDescription());
        kvStoreDao.save(kvStoreEntity);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO update(KvStoreParam kvStoreParam) {
        KvStoreEntity kvStoreEntity = kvStoreDao.getById(kvStoreParam.getUniqueId());
        if (kvStoreEntity != null) {
            kvStoreEntity.setFirstName(kvStoreParam.getFirstName());
            kvStoreEntity.setLastName(kvStoreParam.getLastName());
            kvStoreEntity.setValue(kvStoreParam.getValue());
            kvStoreEntity.setKeyDescription(kvStoreParam.getKeyDescription());
            kvStoreDao.update(kvStoreEntity);
        }
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO delete(Long id) {
        kvStoreDao.deleteById(id);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO list(Integer limit, Integer page) {
        Long count = kvStoreDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<KvStoreEntity> list = kvStoreDao.list(limit, offset);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }
}
