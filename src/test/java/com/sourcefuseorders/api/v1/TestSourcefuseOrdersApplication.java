package com.sourcefuseorders.api.v1;

import org.springframework.boot.SpringApplication;

public class TestSourcefuseOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.from(SourcefuseOrdersApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
