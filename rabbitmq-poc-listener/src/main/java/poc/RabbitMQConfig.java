package poc;



import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String QUEUE_NAME = "MyQueue";


    // create a new queue programaticly
    @Bean
    Queue myQueue(){
        return new Queue(QUEUE_NAME, true);
    }


    @Bean
    Exchange myExchage(){
        return ExchangeBuilder.topicExchange("MyTopicExchange").durable(true).build();
    }

    @Bean
    Binding binding(){

//        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, "MyTopicExchange", "topic", null);

        return BindingBuilder
                .bind(myQueue())
                .to(myExchage())
                .with("topic")
                .noargs();
    }


    // create connection to rabbitMQ broker
    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        return connectionFactory;
    }


    @Bean
    MessageListenerContainer messageListenerContainer(){

        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory());
        messageListenerContainer.setQueues(myQueue());
        messageListenerContainer.setMessageListener(new RabbitMQListener());
        return messageListenerContainer;


    }


}
