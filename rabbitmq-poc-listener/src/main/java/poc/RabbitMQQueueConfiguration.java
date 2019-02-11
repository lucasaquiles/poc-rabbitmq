package poc;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfiguration {

    // declarative way to create Queue
    @Bean
    Queue exampleQueue(){

        return new Queue("ExampleQueue", false);
    }


    // create a new queue using QueueBuilder
    @Bean
    Queue exampleSecondQueue(){

        return  QueueBuilder
                .durable("exampleSecondQueue")
                .autoDelete()
                .exclusive().build();
    }

}
