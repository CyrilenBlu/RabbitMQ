package blu.rabbitmq.receiver.receivers;

import blu.rabbitmq.receiver.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

@RabbitListener(queues = "person")
public class PersonReceiver {

    ObjectMapper obj;

    public PersonReceiver(ObjectMapper obj) {
        this.obj = obj;
    }

    @RabbitHandler
    public void receive(String in) {
        try {
            Person person = obj.readValue(in, Person.class);
            System.out.println(" [x] Received '" + person + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
