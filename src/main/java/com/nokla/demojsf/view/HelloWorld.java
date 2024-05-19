package com.nokla.demojsf.view;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.service.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

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
        input = "";
        logger.warning("yo this is warning from submit");
    }

    public void submitMessage(){
        controllerID = String.valueOf(this);
        try {
            Message newMesssage = message.clone();      //create a clone of the message
            messageService.create(newMesssage);
            messages.add(newMesssage);
            logger.warning("message submitted: " + message.getText());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_INFO, "Message added successfully.", null));
        } catch (Exception e){
            logger.severe("failed to create message exception: "+e.getMessage());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message creation failed.", null));
        } finally {
            message.reset();
        }
    }

    public void deleteMessage(Message message){
        controllerID = String.valueOf(this);
        try {
            messageService.delete(message);
            messages.remove(message);
            logger.warning("deleted message: " + message.getText());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_INFO, "Message deleted successfully.", null));
        } catch (Exception e){
            logger.severe("failed to delete message exceptio: "+e.getMessage());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message deletion failed.", null));
        }
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
