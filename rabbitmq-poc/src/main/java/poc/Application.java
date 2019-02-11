package poc;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String args[]){

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

          SimpleMessage simplesMessage =new SimpleMessage();
          simplesMessage.setNome("Outra mensagem Message");
          simplesMessage.setDescription("simple description");

          rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simplesMessage);
    }
}
