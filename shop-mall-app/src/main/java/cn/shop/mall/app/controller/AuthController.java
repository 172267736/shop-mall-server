package cn.shop.mall.app.controller;

import cn.shop.mall.app.dto.UserDto;
import cn.shop.mall.app.service.AuthService;
import cn.shop.mall.center.entity.UserAppEntity;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LSY on 2020/12/14.
 */
@Api(value = "API登录授权接口", tags = "API登录授权接口")
@RestController
@RequestMapping("/api/wxapp")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "微信登录")
    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserDto userDto) {

        authService.login(userDto.getCode());

        return ResponseVO.SUCCESS("登录成功");
    }


    @ApiOperation(value = "微信注册")
    @PostMapping("/register")
    public ResponseVO register(@RequestBody UserAppEntity userAppEntity) {

        authService.register(userAppEntity);

        return ResponseVO.SUCCESS("注册成功");
    }


}
