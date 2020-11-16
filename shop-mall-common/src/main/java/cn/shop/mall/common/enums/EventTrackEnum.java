package cn.shop.mall.common.enums;

public enum EventTrackEnum {

    客户端登录("admin_login", "客户端登录"),

    删除用户("admin_delete_user", "删除用户"),

    新增用户("admin_save_user", "新增用户"),

    编辑用户("admin_update_user", "编辑用户"),

    删除角色("admin_delete_role", "删除角色"),

    新增角色("admin_save_role", "新增角色"),

    编辑角色("admin_update_role", "编辑角色"),

    更新密码("admin_update_password", "更新密码"),

    删除菜单("admin_delete_menu", "删除菜单"),

    新增菜单("admin_save_menu", "新增菜单"),

    编辑菜单("admin_update_menu", "编辑菜单"),

    删除字典("admin_delete_dic", "删除字典"),

    新增字典("admin_save_dic", "新增字典"),

    编辑字典("admin_update_dic", "编辑字典"),

    新增商品分类("admin_save_goods_classify", "新增商品分类"),

    编辑商品分类("admin_update_goods_classify", "编辑商品分类"),

    新增商品("admin_save_goods", "新增商品"),

    上下架商品("admin_update_goods_status", "上下架商品"),

    更新商品库存("admin_update_goods_sku", "更新商品库存"),

    更新商品价格("admin_update_goods_price", "更新商品价格"),

    客户端登出("admin_login_out", "客户端登出");

    private String tag;

    private String msg;

    EventTrackEnum(String tag, String msg) {
        this.tag = tag;
        this.msg = msg;
    }

    public String getTag() {
        return tag;
    }

    public String getMsg() {
        return msg;
    }
}
