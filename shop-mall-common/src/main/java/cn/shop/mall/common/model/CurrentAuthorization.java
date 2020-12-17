package cn.shop.mall.common.model;

public class CurrentAuthorization {

    private static final ThreadLocal<UserBean> userBeanThreadLocal = new ThreadLocal<>();

    public static UserBean getUserBean() {
        return userBeanThreadLocal.get();
    }

    public static void setUserBean(UserBean authInfo) {
        userBeanThreadLocal.set(authInfo);
    }

    public static void removeUserBean() {
        userBeanThreadLocal.remove();
    }

    public static Long getUniqueId() {
        return getUserBean().getUniqueId();
    }

    public static String getUserName() {
        return getUserBean().getUserName();
    }

    public static String getToken() {
        return getUserBean().getAuthToken();
    }

    public static String getRequestIp() {
        return getUserBean().getRequestIp();
    }

}
