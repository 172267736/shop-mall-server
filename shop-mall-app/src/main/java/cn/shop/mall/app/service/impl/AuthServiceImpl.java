package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.config.WxPropertiesConfig;
import cn.shop.mall.app.service.AuthService;
import cn.shop.mall.center.dao.UserAppDao;
import cn.shop.mall.center.entity.UserAppEntity;
import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.model.CurrentAuthorization;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by LSY on 2020/12/14.
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private WxPropertiesConfig wxPropertiesConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserAppDao userAppDao;

    @Override
    public void login(String code) {

        String requestUrl = String.format(wxPropertiesConfig.getWebAccessTokenhttps(),
                wxPropertiesConfig.getAppId(), wxPropertiesConfig.getSecret(), code);
        log.info("》》》组合token为：" + requestUrl);

        JSONObject resultJson;
        try {
            //获取openid
            resultJson = restTemplate.getForObject(requestUrl, JSONObject.class);
        } catch (Exception e) {
            log.error("获取openID异常");
            throw new BizException("登录失败");
        }
        String openId = resultJson.getString("openid");
        String sessionKey = resultJson.getString("session_key");
        log.info("openId={}, sessionKey={}", openId, sessionKey);
        if (Strings.isNullOrEmpty(openId) || Strings.isNullOrEmpty(sessionKey)) {
            throw new BizException("登录失败");
        }

        //根据openId获取用户信息
        UserAppEntity userApp = userAppDao.get(openId);

        //生成token


    }

    @Override
    public void register(UserAppEntity userAppEntity) {
        userAppEntity.setCreateDate(new Date());
        userAppEntity.setRegisterIp(CurrentAuthorization.getRequestIp());
        userAppDao.save(userAppEntity);
    }


}
