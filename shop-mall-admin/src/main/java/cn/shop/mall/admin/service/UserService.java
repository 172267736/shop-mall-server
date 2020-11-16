package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.UserParam;
import cn.shop.mall.common.vo.ResponseVO;

import java.util.List;

public interface UserService {

    ResponseVO login(UserParam userParam);

    ResponseVO loginOut(String token);

    ResponseVO list(Integer limit, Integer page, String userName);

    ResponseVO delete(List<Long> ids);

    ResponseVO detail(Long id);

    ResponseVO save(UserParam userParam);

    ResponseVO updatePassword(UserParam userParam);

    ResponseVO update(UserParam userParam);

}
