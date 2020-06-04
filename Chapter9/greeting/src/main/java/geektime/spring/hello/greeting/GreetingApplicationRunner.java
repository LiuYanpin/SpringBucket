package geektime.spring.hello.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
public class GreetingApplicationRunner implements ApplicationRunner {
    public GreetingApplicationRunner() {
        log.info("Initializing GreetingApplicationRunner.");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Hello everyone! We all like Spring! ");
    }
}
