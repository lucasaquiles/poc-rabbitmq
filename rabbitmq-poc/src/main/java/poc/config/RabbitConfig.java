package poc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    Exchange topicExchangeExample(){
        return ExchangeBuilder.topicExchange("topic.message_notify.example")
                .autoDelete()
                .internal()
                .durable(true)
                .build();
    }

    @Bean
    Queue queueExample(){

        return  QueueBuilder
                .durable(QueueEnum.EXAMPLE_QUEUE.getQueueName())
                .exclusive().build();
    }


    @Bean
    Binding binding(){

        return BindingBuilder
                .bind(queueExample())
                .to(topicExchangeExample())
                .with("notify_message_example")
                .noargs();
    }

}
