package org.tnmk.practicespringjpa.pro00simpleconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class Pro00SimpleConnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro00SimpleConnectApplication.class, args);
    }
}
