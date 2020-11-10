package cn.shop.mall.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加或者编辑字典")
public class KvStoreParam {

    @ApiModelProperty(value = "主键自增")
    private Long uniqueId;

    @ApiModelProperty(value = "键")
    private String key;

    @ApiModelProperty(value = "组名一")
    private String firstName;

    @ApiModelProperty(value = "组名二")
    private String lastName;

    @ApiModelProperty(value = "值")
    private String value;

    @ApiModelProperty(value = "说明")
    private String keyDescription;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKeyDescription() {
        return keyDescription;
    }

    public void setKeyDescription(String keyDescription) {
        this.keyDescription = keyDescription;
    }
}
