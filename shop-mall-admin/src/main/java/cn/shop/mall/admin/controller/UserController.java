package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.UserParam;
import cn.shop.mall.admin.service.UserService;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserParam userParam) {
        return userService.login(userParam);
    }

    @ApiOperation("用户登出")
    @PostMapping("/loginOut")
    public ResponseVO loginOut() {
        return userService.loginOut(CurrentAuthorization.getToken());
    }

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page,
                           @ApiParam(value = "用户名") @RequestParam(required = false) String userName) {
        return userService.list(limit, page, userName);
    }

    @ApiOperation("用户详情")
    @GetMapping("/detail")
    public ResponseVO detail(@ApiParam(value = "用户编号", required = true) @RequestParam Long id) {
        return userService.detail(id);
    }

    @ApiOperation("用户删除")
    @PostMapping("/delete")
    public ResponseVO delete(@RequestBody UserParam userParam) {
        return userService.delete(userParam.getIds());
    }

    @ApiOperation("用户添加")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody UserParam userParam) {
        return userService.save(userParam);
    }

    @ApiOperation("用户编辑")
    @PostMapping("/update")
    public ResponseVO update(@RequestBody UserParam userParam) {
        Long userId = CurrentAuthorization.getUniqueId();
        return userService.update(userParam);
    }

    @ApiOperation("更新密码")
    @PostMapping("/password/update")
    public ResponseVO updatePassword(@RequestBody UserParam userParam) {
        return userService.updatePassword(userParam);
    }

}
