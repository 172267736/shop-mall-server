package cn.shop.mall.admin.service;

import cn.shop.mall.common.vo.ResponseVO;

public interface UserService {

    ResponseVO login(String userName, String passWord);

    ResponseVO loginOut(String token);

    ResponseVO list(Integer limit, Integer page, String userName);

    ResponseVO delete(Long id);

    ResponseVO save(String userName, String nickName, Long roleId);

    ResponseVO updatePassword(String userName, String oldPassword, String newPassword);

    ResponseVO update(Long userId, String nickName, Long roleId);

}
