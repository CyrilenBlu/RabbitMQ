package blu.rabbitmq.sender.controllers;

import blu.rabbitmq.sender.components.Sender;
import blu.rabbitmq.sender.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    private final Sender sender;

    public PersonController(Sender sender) {
        this.sender = sender;
    }

    @RequestMapping("/")
    public String sendPerson() throws JsonProcessingException {
        Person person = new Person("Luke", 19);
        sender.sendPerson(person);
        return "Hello";
    }
}
