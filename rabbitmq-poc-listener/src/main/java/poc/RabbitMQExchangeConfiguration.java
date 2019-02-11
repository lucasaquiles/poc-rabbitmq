package poc;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

    @Bean
    Exchange exampleExchange(){

       return new TopicExchange("ExampleExchange");
    }

    @Bean
    Exchange example2Exchange(){

        return ExchangeBuilder
                .directExchange("Example2Exchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange newExchange(){

        return ExchangeBuilder
                .topicExchange("TopTestExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("FanoutTestExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange headerExchange(){
        return ExchangeBuilder.headersExchange("HeaderTestExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }
}
