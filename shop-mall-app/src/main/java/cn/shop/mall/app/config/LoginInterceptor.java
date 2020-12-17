package cn.shop.mall.app.config;

import cn.shop.mall.common.enums.CodeMsgEnum;
import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.model.UserBean;
import cn.shop.mall.common.model.UserHeader;
import com.google.common.base.Strings;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 拦截器：获取请求头到安全模块验证，验证通过后存储用户信息
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader(UserHeader.AuthToken);
        if (Strings.isNullOrEmpty(token)) {
            throw new BizException(CodeMsgEnum.请登录);
        }

        //获取小程序的用户ID
        UserBean user = new UserBean();
        user.build(UserHeader.RequestIp, getClientIp(request));

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
    }

    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    private String getClientIp(HttpServletRequest request) {
        String xff = request.getHeader("X-Real-IP");
        if (xff != null) {
            return xff;
        }
        xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return "8.8.8.8";
        }
        return xff;
    }

}
