package cn.shop.mall.app.controller;

import cn.shop.mall.app.service.AddressService;
import cn.shop.mall.center.entity.UserAllocationAddressEntity;
import cn.shop.mall.common.enums.TagEnum;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LSY on 2020/11/22.
 * 地址管理表
 */
@Api(tags = "地址相关")
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 地址列表
     *
     * @return 地址列表
     */
    @ApiOperation("app-地址列表")
    @GetMapping("/list")
    public ResponseVO list() {
        return ResponseVO.SUCCESS(addressService.list());
    }

    /**
     * 保存地址
     *
     * @param addressEntity 地址实体
     * @return 状态码
     */
    @ApiOperation("app-保存地址")
    @PostMapping
    public ResponseVO save(@RequestBody UserAllocationAddressEntity addressEntity) {
        return addressService.save(addressEntity);
    }

    /**
     * 修改地址
     *
     * @param addressEntity 地址实体
     * @return 状态码
     */
    @ApiOperation("app-修改地址")
    @PutMapping
    public ResponseVO update(@RequestBody UserAllocationAddressEntity addressEntity) {
        return addressService.update(addressEntity);
    }

    /**
     * 查找地址详情
     *
     * @param addressId 地址ID
     * @return 地址实体
     */
    @ApiOperation("app-查找地址详情")
    @GetMapping("/{addressId}")
    public ResponseVO queryById(@PathVariable("addressId") Long addressId) {
        return ResponseVO.SUCCESS(addressService.queryById(addressId));
    }

    /**
     * 查看地址Tag
     * @return
     */
    @ApiOperation("app-查找地址Tag")
    @GetMapping("/queryTags")
    public ResponseVO queryTags(){
        return ResponseVO.SUCCESS(TagEnum.getTags());
    }

}
