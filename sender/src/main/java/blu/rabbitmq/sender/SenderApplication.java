package blu.rabbitmq.sender;

import blu.rabbitmq.sender.components.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

}
