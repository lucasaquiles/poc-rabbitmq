package poc.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.controller.request.MessageRequest;
import poc.model.SimpleMessage;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    protected final String MY_TOPIC_EXCHANGE = "MyTopicExchange";
    protected final String QUEUE_EXAMPLE = "poc.queue.example";

    @Override
    public void publish(final MessageRequest messageRequest){

        final SimpleMessage simpleMessage = SimpleMessage
                .builder()
                .name(messageRequest.getName())
                .description(messageRequest.getDescription())
                .build();

        rabbitTemplate.convertAndSend("poc.queue.example", simpleMessage);
    }
}
