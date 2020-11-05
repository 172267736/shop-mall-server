package cn.shop.mall.admin.service.impl;

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
    public ResponseVO save(String key, String firstName, String lastName, String value, String keyDescription) {
        if (kvStoreDao.getByKey(key) != null) {
            return ResponseVO.FAIL("当前键值对已经存在");
        }
        KvStoreEntity kvStoreEntity = new KvStoreEntity();
        kvStoreEntity.setKey(key);
        kvStoreEntity.setFirstName(firstName);
        kvStoreEntity.setLastName(lastName);
        kvStoreEntity.setValue(value);
        kvStoreEntity.setKeyDescription(keyDescription);
        kvStoreDao.save(kvStoreEntity);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO update(Long id, String firstName, String lastName, String value, String keyDescription) {
        KvStoreEntity kvStoreEntity = kvStoreDao.getById(id);
        if (kvStoreEntity != null) {
            kvStoreEntity.setFirstName(firstName);
            kvStoreEntity.setLastName(lastName);
            kvStoreEntity.setValue(value);
            kvStoreEntity.setKeyDescription(keyDescription);
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
    public ResponseVO list() {
        Long count = kvStoreDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<KvStoreEntity> list = kvStoreDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }
}
