package blu.rabbitmq.receiver.handlers;

import blu.rabbitmq.receiver.receivers.HelloWorldReceiver;
import blu.rabbitmq.receiver.receivers.PersonReceiver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverHandling {

    @Bean
    public HelloWorldReceiver receiver() {
        return new HelloWorldReceiver();
    }

    @Bean
    public PersonReceiver personReceiver() {
        return new PersonReceiver(new ObjectMapper());
    }

}
