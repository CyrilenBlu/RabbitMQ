package blu.rabbitmq.sender.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    Queue helloWorldQueue() {
        return new Queue("hello");
    }

    @Bean
    Queue personQueue() {
        return new Queue("person");
    }
}
