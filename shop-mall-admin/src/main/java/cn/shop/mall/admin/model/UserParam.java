package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("添加或者编辑用户")
public class UserParam {

    @ApiModelProperty(value = "主键自增")
    private Long uniqueId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "姓名")
    private String nickName;

    @ApiModelProperty(value = "角色编号")
    private List<Long> roleIdList;

    @ApiModelProperty(value = "原密码")
    private String password;

    @ApiModelProperty(value = "新密码")
    private String newPassword;

    @ApiModelProperty(value = "用户状态（0：正常；1：异常）")
    private Integer userState;

    @ApiModelProperty(value = "编号集合")
    private List<Long> ids;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
