package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加或者编辑商品分类")
public class GoodsClassifyParam {

    @ApiModelProperty(value = "主键唯一")
    private Long uniqueId;

    @ApiModelProperty(value = "分类名称")
    private String classifyName;

    @ApiModelProperty(value = "分类父编号")
    private Long classifyParentId;

    @ApiModelProperty(value = "分类图标")
    private String classifyIcon;

    @ApiModelProperty(value = "分类说明")
    private String classifyDescription;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Long getClassifyParentId() {
        return classifyParentId;
    }

    public void setClassifyParentId(Long classifyParentId) {
        this.classifyParentId = classifyParentId;
    }

    public String getClassifyIcon() {
        return classifyIcon;
    }

    public void setClassifyIcon(String classifyIcon) {
        this.classifyIcon = classifyIcon;
    }

    public String getClassifyDescription() {
        return classifyDescription;
    }

    public void setClassifyDescription(String classifyDescription) {
        this.classifyDescription = classifyDescription;
    }
}
