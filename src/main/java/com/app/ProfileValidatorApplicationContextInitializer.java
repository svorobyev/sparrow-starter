package com.app;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ProfileValidatorApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        final String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        if (activeProfiles.length == 0) {
            System.out.println("No profiles...");
        }
    }
}
