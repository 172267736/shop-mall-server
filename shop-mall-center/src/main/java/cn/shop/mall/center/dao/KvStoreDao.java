package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.KvStoreEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典表
 */
@Mapper
public interface KvStoreDao {

    Integer save(KvStoreEntity kvStoreEntity);

    Integer update(KvStoreEntity kvStoreEntity);

    KvStoreEntity getByKey(String key);

    KvStoreEntity getById(Long id);

    Integer deleteById(Long id);

    Long count();

    List<KvStoreEntity> list();

}
