package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.KvStoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典表
 */
@Mapper
public interface KvStoreDao {

    Integer save(KvStoreEntity kvStoreEntity);

    Integer update(KvStoreEntity kvStoreEntity);

    KvStoreEntity getByKeyFlag(String keyFlag);

    KvStoreEntity getById(Long id);

    Integer deleteByIds(List<Long> ids);

    Long count(@Param("keyFlag") String keyFlag);

    List<KvStoreEntity> list(@Param("keyFlag") String keyFlag, @Param("limit") Integer limit, @Param("offset") Integer offset);

}
