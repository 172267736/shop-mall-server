package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.service.MenuService;
import cn.shop.mall.center.dao.MenuDao;
import cn.shop.mall.center.entity.MenuEntity;
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
    public ResponseVO list() {
        Long count = menuDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<MenuEntity> list = menuDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }

    /**
     * 添加菜单
     */
    @Override
    public ResponseVO save(MenuEntity menuEntity) {
        menuDao.save(menuEntity);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO update(MenuEntity menuEntity) {
        menuDao.update(menuEntity);
        return ResponseVO.SUCCESS();
    }
}
