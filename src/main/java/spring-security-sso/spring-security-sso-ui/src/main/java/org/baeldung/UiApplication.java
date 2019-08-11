package org.baeldung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author: create by Chenyu Wang
 * @version: v1.0
 * @description: org.baeldung.controller
 * @date:2019-08-09
 */
@SpringBootApplication
public class UiApplication extends SpringBootServletInitializer {
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}
