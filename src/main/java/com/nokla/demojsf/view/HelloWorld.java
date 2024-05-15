package com.nokla.demojsf.view;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.service.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class HelloWorld {
    private String input;
    private String output;
    private String controllerID;

    private Message message = new Message();
    private List<Message> messages;

    @Inject
    private MessageService messageService;

    public String getOutput() {
        return output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @PostConstruct
    public void init(){
        messages = messageService.getMessages();
    }

    public void submit(){
        controllerID = String.valueOf(this);
        System.out.println("helloworld bean address: " + this);
        output = "your input: " + input;
        if (input == null){
            output = "";
        }
    }

    public void submitMessage(){
        controllerID = String.valueOf(this);
        System.out.println("helloworld bean address: " + this);

        messageService.create(message);
        messages.add(message);
    }



    public String getControllerID() {
        return controllerID;
    }

    public Message getMessage() {
        return message;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
