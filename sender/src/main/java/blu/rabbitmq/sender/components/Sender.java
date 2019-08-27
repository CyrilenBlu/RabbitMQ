package blu.rabbitmq.sender.components;

import blu.rabbitmq.sender.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    private final RabbitTemplate template;

    private final ObjectMapper obj;

    private final Queue personQueue;

    private final Queue helloQueue;

    public Sender(ObjectMapper obj,
                  @Qualifier("personQueue") Queue personQueue,
                  @Qualifier("helloWorldQueue") Queue helloQueue,
                  RabbitTemplate template) {
        this.obj = obj;
        this.personQueue = personQueue;
        this.helloQueue = helloQueue;
        this.template = template;
    }

    @Scheduled(fixedDelay = 100000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(helloQueue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

    public void sendPerson(Person person) throws JsonProcessingException {
            String jsonPerson = obj.writeValueAsString(person);
            System.out.println(jsonPerson);
            this.template.convertAndSend(personQueue.getName(), jsonPerson);
            System.out.println(" [x] Sent '" + person + "'");
    }
}
