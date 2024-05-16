package com.nokla.demojsf.view;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.service.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.PostLoad;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class HelloWorld {
    protected Logger logger = Logger.getLogger(HelloWorld.class.getName());
    private String input;
    private String output;
    private String controllerID;

    private final Message message = new Message();
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
        logger.warning("this is the init with @postconstruct");
    }

    public void submit(){
        controllerID = String.valueOf(this);
        System.out.println("helloworld bean address: " + this);
        output = "your input: " + input;
        if (input == null){
            output = "";
        }
        logger.warning("yo this is warning from submit");
    }

    public void submitMessage(){
        controllerID = String.valueOf(this);
        logger.warning("before submit msg len: " + messages.size());
        controllerID = String.valueOf(this);
        messageService.create(message);
        messages.add(message);
        logger.warning("message submitted: " + message);

//        messages.forEach(message1 -> logger.warning(message1.getText()));
        logger.warning("after submit msg len: " + messages.size());
        FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_INFO, "Message added successfully.", null));

    }

    public void deleteMessage(Message message){
        controllerID = String.valueOf(this);
        messageService.delete(message);
        messages.remove(message);
        logger.warning("delete message");
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
