package cn.shop.mall.common.model;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class PageDto<T> {

    @ApiModelProperty(value = "数据")
    private List<T> list;

    @ApiModelProperty(value = "总数")
    private Long count;

    public PageDto() {
        count = 0L;
        list = Lists.newArrayList();
    }

    public PageDto(List<T> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public PageDto(List<T> list, Integer count) {
        this.list = list;
        this.count = Long.valueOf(count);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
