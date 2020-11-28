package cn.shop.mall.common.model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class UserBean extends JSONObject {

    private Long userId;

    public UserBean build(String key, Object value) {
        this.put(key, value);
        return this;
    }

    public String getAuthToken() {
        return this.getString(UserHeader.AuthToken);
    }

    public Long getUniqueId() {
        return this.getLong(UserHeader.UniqueId);
    }

    public String getUserName() {
        return this.getString(UserHeader.UserName);
    }

    public String getNickName() {
        return this.getString(UserHeader.NickName);
    }

    public String getPhone() {
        return this.getString(UserHeader.Phone);
    }

    public String getRequestIp() {
        return this.getString(UserHeader.RequestIp);
    }

    public List<String> getAuthUriList() {
        return this.getObject(UserHeader.AuthUriList, List.class);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

