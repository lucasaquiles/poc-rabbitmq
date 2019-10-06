package poc.config;

import lombok.Getter;

@Getter
public enum QueueEnum {

    EXAMPLE_QUEUE("poc.queue.example");

    private String queueName;
    QueueEnum(String queueName){

        this.queueName = queueName;
    }
}
