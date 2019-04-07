package com.jpoint.starter;

import com.app.MailNotifier;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static java.lang.System.currentTimeMillis;

@Aspect
@RequiredArgsConstructor
public class BenchmarkAspect {

    private final MailNotifier mailNotifier;

    @Around("@annotation(com.jpoint.starter.Benchmark) && execution(* com.jpoint..*.*(..))")
    @SneakyThrows
    public Object methodBenchmark(ProceedingJoinPoint point) {
        System.out.println("Start benchmark for " + point.getSignature().getName() + "...");
        final long begin = currentTimeMillis();
        Object result = point.proceed();
        final long delta = currentTimeMillis() - begin;
        final String benchmarkMsg = point.getSignature().getName() + " invocation in" + delta + "ms";
        System.out.println(benchmarkMsg);
        mailNotifier.sendMailNotification(benchmarkMsg);
        return result;
    }

}
