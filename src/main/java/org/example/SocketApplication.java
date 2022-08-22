package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/18 22:53
 */
@Slf4j
@SpringBootApplication
public class SocketApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SocketApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        log.info("啟動成功");
    }
}
