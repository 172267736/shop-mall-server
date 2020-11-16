package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.event.EventTrack;
import cn.shop.mall.admin.model.MenuParam;
import cn.shop.mall.admin.service.MenuService;
import cn.shop.mall.center.dao.MenuDao;
import cn.shop.mall.center.entity.MenuEntity;
import cn.shop.mall.common.enums.EventTrackEnum;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.model.UserHeader;
import cn.shop.mall.common.vo.ResponseVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 菜单列表
     */
    @Override
    public ResponseVO listByUser(String userName, Long userId) {
        List<MenuEntity> menus;
        if (userName.equals(UserHeader.Admin)) {
            menus = menuDao.listAllMenu();
        } else {
            menus = menuDao.listMenuByUserId(userId);
        }
        Map<Long, MenuEntity> map = Maps.uniqueIndex(menus, MenuEntity::getUniqueId);
        List<MenuEntity> result = Lists.newArrayList();
        for (Map.Entry<Long, MenuEntity> entry : map.entrySet()) {
            MenuEntity menu = entry.getValue();
            if (!menu.getParentUniqueId().equals(0L)) {
                List<MenuEntity> child = map.get(menu.getParentUniqueId()).getChild();
                if (CollectionUtils.isEmpty(child)) {
                    child = Lists.newArrayList();
                    child.add(menu);
                    map.get(menu.getParentUniqueId()).setChild(child);
                } else {
                    child.add(menu);
                }
            }
        }
        for (Map.Entry<Long, MenuEntity> entry : map.entrySet()) {
            MenuEntity menu = entry.getValue();
            if (menu.getParentUniqueId().equals(0L)) {
                result.add(menu);
            }
        }
        return ResponseVO.SUCCESS(result);
    }

    /**
     * 菜单列表
     */
    @Override
    public ResponseVO list(Integer limit, Integer page, String menuName, Integer menuType) {
        Long count = menuDao.count(menuName, menuType);
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<MenuEntity> list = menuDao.list(limit, offset, menuName, menuType);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }

    /**
     * 菜单列表
     */
    @Override
    public ResponseVO listAll() {
        return ResponseVO.SUCCESS(menuDao.listAll());
    }

    @Override
    public ResponseVO detail(Long id) {
        return ResponseVO.SUCCESS(menuDao.getById(id));
    }

    @EventTrack(value = EventTrackEnum.删除菜单)
    @Override
    public ResponseVO delete(List<Long> ids) {
        return ResponseVO.SUCCESS(menuDao.deleteByIds(ids));
    }

    /**
     * 添加菜单
     */
    @EventTrack(value = EventTrackEnum.新增菜单)
    @Override
    public ResponseVO save(MenuParam menuParam) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setIcon(menuParam.getIcon());
        menuEntity.setMenuName(menuParam.getMenuName());
        menuEntity.setMenuUrl(menuParam.getMenuUrl());
        menuEntity.setMenuType(menuParam.getMenuType());
        menuEntity.setParentUniqueId(menuEntity.getParentUniqueId());
        menuDao.save(menuEntity);
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.编辑菜单)
    @Override
    public ResponseVO update(MenuParam menuParam) {
        MenuEntity menuEntity = menuDao.getById(menuParam.getUniqueId());
        menuEntity.setIcon(menuParam.getIcon());
        menuEntity.setMenuName(menuParam.getMenuName());
        menuEntity.setMenuUrl(menuParam.getMenuUrl());
        menuEntity.setMenuType(menuParam.getMenuType());
        menuEntity.setParentUniqueId(menuParam.getParentUniqueId());
        menuDao.update(menuEntity);
        return ResponseVO.SUCCESS();
    }
}
