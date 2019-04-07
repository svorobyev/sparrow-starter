package com.jpoint.starter;

import com.app.MailNotifier;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@RequiredArgsConstructor
public class DeprecatedAspect {

    private final MailNotifier mailNotifier;

    @Before("@annotation(Deprecated) && execution(* com.jpoint..*.*(..))")
    public void warnDeprecated(JoinPoint jp) {
        String msg = "This method " + jp.getSignature().getName() + " is deprecated";
        System.out.println(msg);
        mailNotifier.sendMailNotification(msg);
    }
}
