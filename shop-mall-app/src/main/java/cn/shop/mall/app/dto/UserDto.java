package cn.shop.mall.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by LSY on 2020/12/14.
 */
@Data
public class UserDto implements Serializable {

    private String code;

    private String uniqueId;

    private String headerImg;

    private Integer sex;

    private String phone;

    private String nickName;

    private String password;

    private Date lastLoginIp;

    private String registerIp;

    private String weixinOpenid;

    private Integer deleted;

    private Date createDate;

    private Date updateDate;

}
