package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("添加或者编辑字典")
public class KvStoreParam {

    @ApiModelProperty(value = "主键自增")
    private Long uniqueId;

    @ApiModelProperty(value = "键")
    private String keyFlag;

    @ApiModelProperty(value = "组名一")
    private String firstName;

    @ApiModelProperty(value = "组名二")
    private String lastName;

    @ApiModelProperty(value = "值")
    private String storeValue;

    @ApiModelProperty(value = "说明")
    private String keyDescription;

    @ApiModelProperty(value = "编号集合")
    private List<Long> ids;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(String keyFlag) {
        this.keyFlag = keyFlag;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStoreValue() {
        return storeValue;
    }

    public void setStoreValue(String storeValue) {
        this.storeValue = storeValue;
    }

    public String getKeyDescription() {
        return keyDescription;
    }

    public void setKeyDescription(String keyDescription) {
        this.keyDescription = keyDescription;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
