package cn.shop.mall.center.entity;

import lombok.Data;

import java.util.Date;

/**
 * 应用用户表
 */
@Data
public class UserAppEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String headerImg;

    /**
     * 性别（0：未知；1：男；2：女；）
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后登录IP
     */
    private Date lastLoginIp;

    /**
     * 注册IP
     */
    private String registerIp;

    /**
     * 微信OPENID
     */
    private String weixinOpenid;


    /**
     * 是否删除（0：否；1：删除）
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;


}
