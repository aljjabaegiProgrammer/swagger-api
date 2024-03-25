package com.aljjabaegi.swagger.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ApiApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    /**
     * application.yml 설정 파일을 읽어 Swagger 연결 정보 출력
     */
    @Component
    public class SwaggerInformation implements ApplicationRunner {
        @Value("${server.port}")
        private String port;
        @Value("${server.servlet.context-path}")
        private String contextPath;

        @Override
        public void run(ApplicationArguments args) {
            LOGGER.info("Swagger : http://localhost:" + port + contextPath + "/swagger-ui/index.html");
        }
    }
}
