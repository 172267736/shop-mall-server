package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.event.EventTrack;
import cn.shop.mall.admin.model.KvStoreParam;
import cn.shop.mall.admin.service.KvStoreService;
import cn.shop.mall.center.dao.KvStoreDao;
import cn.shop.mall.center.entity.KvStoreEntity;
import cn.shop.mall.common.enums.EventTrackEnum;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KvStoreServiceImpl implements KvStoreService {

    @Autowired
    private KvStoreDao kvStoreDao;

    @EventTrack(value = EventTrackEnum.新增字典)
    @Override
    public ResponseVO save(KvStoreParam kvStoreParam) {
        if (kvStoreDao.getByKeyFlag(kvStoreParam.getKeyFlag()) != null) {
            return ResponseVO.FAIL("当前键值对已经存在");
        }
        KvStoreEntity kvStoreEntity = new KvStoreEntity();
        kvStoreEntity.setKeyFlag(kvStoreParam.getKeyFlag());
        kvStoreEntity.setFirstName(kvStoreParam.getFirstName());
        kvStoreEntity.setLastName(kvStoreParam.getLastName());
        kvStoreEntity.setStoreValue(kvStoreParam.getStoreValue());
        kvStoreEntity.setKeyDescription(kvStoreParam.getKeyDescription());
        kvStoreDao.save(kvStoreEntity);
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.编辑字典)
    @Override
    public ResponseVO update(KvStoreParam kvStoreParam) {
        KvStoreEntity kvStoreEntity = kvStoreDao.getById(kvStoreParam.getUniqueId());
        if (kvStoreEntity != null) {
            kvStoreEntity.setFirstName(kvStoreParam.getFirstName());
            kvStoreEntity.setLastName(kvStoreParam.getLastName());
            kvStoreEntity.setStoreValue(kvStoreParam.getStoreValue());
            kvStoreEntity.setKeyDescription(kvStoreParam.getKeyDescription());
            kvStoreDao.update(kvStoreEntity);
        }
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.删除字典)
    @Override
    public ResponseVO delete(List<Long> ids) {
        kvStoreDao.deleteByIds(ids);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO detail(Long id) {
        return ResponseVO.SUCCESS(kvStoreDao.getById(id));
    }

    @Override
    public ResponseVO list(String keyFlag, Integer limit, Integer page) {
        Long count = kvStoreDao.count(keyFlag);
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<KvStoreEntity> list = kvStoreDao.list(keyFlag, limit, offset);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }
}
