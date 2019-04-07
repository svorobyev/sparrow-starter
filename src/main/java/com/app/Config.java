package com.app;

import com.jpoint.starter.BenchmarkAspect;
import com.jpoint.starter.DbExceptionHandler;
import com.jpoint.starter.DeprecatedAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(MailHolder.class)
public class Config {

    @Bean
    @ConditionalOnMissingBean
    public MailHolder mailHolder() {
        return new MailHolder();
    }

    @Bean
    @ConditionalOnMissingBean
    public MailNotifier mailNotifier(MailHolder mailHolder) {
        System.out.println("Mail notifier is needed");
        return new MailNotifier(mailHolder);
    }

    @Bean
    public DeprecatedAspect deprecatedAspect(MailNotifier mailNotifier) {
        return new DeprecatedAspect(mailNotifier);
    }

    @Bean
    public BenchmarkAspect benchmarkAspect(MailNotifier mailNotifier) {
        return new BenchmarkAspect(mailNotifier);
    }

    @Bean
    public DbExceptionHandler dbExceptionHandler(MailNotifier mailNotifier) {
        return new DbExceptionHandler(mailNotifier);
    }


}
