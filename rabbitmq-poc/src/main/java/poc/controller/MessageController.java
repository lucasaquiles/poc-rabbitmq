package poc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import poc.controller.request.MessageRequest;
import poc.service.MessageService;

import javax.validation.Valid;

@RestController("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void publish(@RequestBody @Valid MessageRequest request){

        messageService.publish(request);
    }
}
