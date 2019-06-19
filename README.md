Simple POC to learing about AMQP protocol using RabbitMQ and Spring Boot.

- rabbitmq using docker

```
docker run -d — hostname my-rabbit — name rabbit13 -p 8080:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management
```

[rabbitmq-poc](https://github.com/lucasaquiles/poc-rabbitmq/tree/master/rabbitmq-poc)
- Uses RabbitTemplate to send messages to a exchange with routing keys

[rabbitmq-poc-listener](https://github.com/lucasaquiles/poc-rabbitmq/tree/master/rabbitmq-poc-listener)
- Create Listeners to receive messages
- How to create Queues, Exchanges (Topic, Direct, Header, Fanout) and Bindings programmatically. 


