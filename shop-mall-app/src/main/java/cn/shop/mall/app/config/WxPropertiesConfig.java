package cn.shop.mall.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by LSY on 2020/12/14.
 */
@Component
@ConfigurationProperties(prefix = "wx")
@Data
public class WxPropertiesConfig {

    private String webAccessTokenhttps;

    private String appId;

    private String secret;

}
