package xyz.zalaya.sqler.backend.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.zalaya.sqler.backend.infrastructure")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
