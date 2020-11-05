package cn.shop.mall.center.entity;

import java.util.Date;

/**
 * 商品分类表
 */
public class GoodsClassifyEntity {

    /**
     * 主键自增
     */
    private Long uniqueId;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 父编号
     */
    private Long classifyParentId;

    /**
     * 分类图标
     */
    private String classifyIcon;

    /**
     * 分类说明
     */
    private String classifyDescription;

    /**
     * 是否删除（0：否；1：删除）
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    public void setUniqueId(Long uniqueId){
        this.uniqueId = uniqueId;
    }

    public Long getUniqueId(){
        return uniqueId;
    }

    public void setClassifyName(String classifyName){
        this.classifyName = classifyName;
    }

    public String getClassifyName(){
        return classifyName;
    }

    public void setClassifyParentId(Long classifyParentId){
        this.classifyParentId = classifyParentId;
    }

    public Long getClassifyParentId(){
        return classifyParentId;
    }

    public void setClassifyIcon(String classifyIcon){
        this.classifyIcon = classifyIcon;
    }

    public String getClassifyIcon(){
        return classifyIcon;
    }

    public void setClassifyDescription(String classifyDescription){
        this.classifyDescription = classifyDescription;
    }

    public String getClassifyDescription(){
        return classifyDescription;
    }

    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }

    public Integer getDeleted(){
        return deleted;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getCreateDate(){
        return createDate;
    }

    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

}
