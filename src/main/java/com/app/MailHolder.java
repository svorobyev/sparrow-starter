package com.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mails")
@Data
public class MailHolder {

    private String dba;
}
