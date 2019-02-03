package com.se7en.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.system")
public class SysProperties {
    private String phpId;
    private String dataUrl;

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getPhpId() {
        return phpId;
    }

    public void setPhpId(String phpId) {
        this.phpId = phpId;
    }
}
