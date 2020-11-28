package cn.shop.mall.app.config;

import cn.shop.mall.common.enums.CodeMsgEnum;
import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.model.UserBean;
import cn.shop.mall.common.model.UserHeader;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 拦截器：获取请求头到安全模块验证，验证通过后存储用户信息
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        /*String token = request.getHeader(UserHeader.AuthToken);
        if (StringUtils.isEmpty(token)) {
            throw new BizException(CodeMsgEnum.参数有误);
        }
        //从redis获取用户信息
        String userStr = redisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(userStr)) {
            //用户信息不存在
            throw new BizException(CodeMsgEnum.请登录);
        }
        UserBean user = JSON.parseObject(userStr, UserBean.class);
        String uri = request.getRequestURI();
        if (!user.getAuthUriList().contains(uri)) {
            //用户无权限
            throw new BizException(CodeMsgEnum.无权限请联系管理员);
        }*/

        //获取小程序的用户ID
        UserBean user = new UserBean();
        String userId = request.getHeader(UserHeader.UserId);
        if (StringUtils.isEmpty(userId)) {
            throw new BizException(CodeMsgEnum.请登录);
        }
        user.setUserId(Long.parseLong(userId));

        CurrentAuthorization.setUserBean(user);
        return true;
    }

    /**
     * controller 执行之后，且页面渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CurrentAuthorization.removeUserBean();
        //去掉实体中的Page属性


    }

}
