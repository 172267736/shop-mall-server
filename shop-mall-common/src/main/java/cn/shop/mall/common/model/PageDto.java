package cn.shop.mall.common.model;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class PageDto<T> {

    @ApiModelProperty(value = "数据")
    private List<T> list;

    @ApiModelProperty(value = "总条数")
    private Long count;

    @ApiModelProperty(value = "总页数")
    private Long page;

    @ApiModelProperty(value = "每页条数")
    private Integer limit;

    public PageDto() {
        this.list = Lists.newArrayList();
        this.count = 0L;
        this.page = 0L;
    }

    public PageDto(List<T> list, Long count, Integer limit) {
        this.list = list;
        this.count = count;
        this.limit = limit;
        this.page = count / limit + 1;
    }


    public PageDto(List<T> list, Integer count, Integer limit) {
        this.list = list;
        this.count = Long.valueOf(count);
        this.limit = limit;
        this.page = this.count / limit + 1;
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

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
