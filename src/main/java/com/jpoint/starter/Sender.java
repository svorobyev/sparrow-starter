package com.jpoint.starter;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Deprecated
    public void sayDeprecated() {
        System.out.println("oops...");
    }

    @SneakyThrows
    @Benchmark
    public void checkBenchmark() {
        Thread.sleep(1000L);
        System.out.println("Processing...");
        throw new IllegalStateException("FIRE");
    }

}
