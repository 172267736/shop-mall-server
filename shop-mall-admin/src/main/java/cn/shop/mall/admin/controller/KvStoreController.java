package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.KvStoreParam;
import cn.shop.mall.admin.service.KvStoreService;
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

@Api(tags = "字典相关")
@RestController
@RequestMapping(value = "/kv/store")
public class KvStoreController {

    @Autowired
    private KvStoreService kvStoreService;

    @ApiOperation("字典列表")
    @GetMapping("/list")
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page) {
        return kvStoreService.list(limit, page);
    }

    @ApiOperation("字典添加")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody KvStoreParam kvStoreParam) {
        return kvStoreService.save(kvStoreParam);
    }

    @ApiOperation("字典更新")
    @PostMapping("/update")
    public ResponseVO update(@RequestBody KvStoreParam kvStoreParam) {
        return kvStoreService.update(kvStoreParam);
    }

    @ApiOperation("字典删除")
    @PostMapping("/delete")
    public ResponseVO delete(@ApiParam(value = "键", required = true) @RequestParam Long id) {
        return kvStoreService.delete(id);
    }

}
