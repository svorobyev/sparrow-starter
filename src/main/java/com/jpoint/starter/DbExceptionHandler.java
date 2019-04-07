package com.jpoint.starter;

import com.app.MailNotifier;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Aspect
@RequiredArgsConstructor
public class DbExceptionHandler {

    private final MailNotifier mailNotifier;

    @Pointcut("execution(* com.jpoint..*.*(..))")
    public void businessMethods() {

    }

    @Pointcut("execution(* com.app..*())")
    public void app(){}

    @ConditionalOnProperty("mails.dba")
    @AfterThrowing(value = "!app() && businessMethods()", throwing = "ex")
    public void handleException(IllegalStateException ex) {
        System.out.println("Exception caught: ");
        mailNotifier.sendMailNotification(ex.getMessage());
    }

}
