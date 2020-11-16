package cn.shop.mall.common.model;

import lombok.Data;

/**
 * Created by LSY on 2020/11/16.
 */
@Data
public class PageBean {
    //当前页
    private Long page;
    //每页条数
    private Long limit;
}
