package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.service.KvStoreService;
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

@Api(tags = "字典相关")
@RestController
@RequestMapping(value = "/kv/store")
public class KvStoreController {

    @Autowired
    private KvStoreService kvStoreService;

    @ApiOperation("字典列表")
    @GetMapping("/list")
    public ResponseVO list() {
        return kvStoreService.list();
    }

    @ApiOperation("字典添加")
    @PostMapping("/save")
    public ResponseVO save(@ApiParam(value = "键", required = true) @RequestParam String key,
                           @ApiParam(value = "组名一") @RequestParam(required = false) String firstName,
                           @ApiParam(value = "组名二") @RequestParam(required = false) String lastName,
                           @ApiParam(value = "值", required = true) @RequestParam String value,
                           @ApiParam(value = "说明") @RequestParam(required = false) String keyDescription) {
        return kvStoreService.save(key, firstName, lastName, value, keyDescription);
    }

    @ApiOperation("字典更新")
    @PostMapping("/update")
    public ResponseVO update(@ApiParam(value = "键", required = true) @RequestParam Long id,
                             @ApiParam(value = "组名一") @RequestParam(required = false) String firstName,
                             @ApiParam(value = "组名二") @RequestParam(required = false) String lastName,
                             @ApiParam(value = "值", required = true) @RequestParam String value,
                             @ApiParam(value = "说明") @RequestParam(required = false) String keyDescription) {
        return kvStoreService.update(id, firstName, lastName, value, keyDescription);
    }

    @ApiOperation("字典删除")
    @PostMapping("/delete")
    public ResponseVO delete(@ApiParam(value = "键", required = true) @RequestParam Long id) {
        return kvStoreService.delete(id);
    }

}
