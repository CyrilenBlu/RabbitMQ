package blu.rabbitmq.receiver.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    ObjectMapper obj() {
        return new ObjectMapper();
    }
}
