package cn.shop.mall.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * Created by LSY on 2020/11/22.
 * 传入参数使用，返回参数去掉
 */
@Data
public class PageBean {

    @JsonInclude(Include.NON_NULL)
    public Integer page;
    @JsonInclude(Include.NON_NULL)
    public Integer limit;
    @JsonInclude(Include.NON_NULL)
    public Integer offset;

    public void setOffset(Integer page, Integer limit){
        Integer offset = (page - 1) * limit;
        this.offset = offset;
    }
}
