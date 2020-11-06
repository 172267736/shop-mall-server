package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.service.UserService;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseVO login(@ApiParam(value = "用户名", required = true) @RequestParam String userName,
                            @ApiParam(value = "密码", required = true) @RequestParam String password) {
        return userService.login(userName, password);
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

    @ApiOperation("用户删除")
    @PostMapping("/delete")
    public ResponseVO delete(@ApiParam(value = "用户编号", required = true) @RequestParam Long id) {
        return userService.delete(id);
    }

    @ApiOperation("用户添加")
    @PostMapping("/save")
    public ResponseVO save(@ApiParam(value = "用户名", required = true) @RequestParam String userName,
                           @ApiParam(value = "姓名", required = true) @RequestParam String nickName,
                           @ApiParam(value = "角色编号", required = true) @RequestParam Long roleId) {
        return userService.save(userName, nickName, roleId);
    }

    @ApiOperation("用户编辑")
    @PostMapping("/update")
    public ResponseVO update(@ApiParam(value = "姓名") @RequestParam(required = false) String nickName,
                             @ApiParam(value = "角色编号") @RequestParam(required = false) Long roleId) {
        Long userId = CurrentAuthorization.getUniqueId();
        return userService.update(userId, nickName, roleId);
    }

    @ApiOperation("更新密码")
    @PostMapping("/password/update")
    public ResponseVO updatePassword(@ApiParam(value = "用户名", required = true) @RequestParam String userName,
                                     @ApiParam(value = "原密码", required = true) @RequestParam String oldPwd,
                                     @ApiParam(value = "新密码", required = true) @RequestParam String newPwd) {
        return userService.updatePassword(userName, oldPwd, newPwd);
    }

}
