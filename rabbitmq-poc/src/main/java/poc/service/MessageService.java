package poc.service;

import poc.controller.request.MessageRequest;

public interface MessageService {

    void publish(MessageRequest messageRequest);
}
