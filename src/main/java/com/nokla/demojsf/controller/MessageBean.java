package com.nokla.demojsf.controller;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.service.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

@Named
@RequestScoped
public class MessageBean {
    protected Logger logger = Logger.getLogger(MessageBean.class.getName());
    @Setter
    @Getter
    private String input;
    @Getter
    private String output;
    private String controllerID;

    private String messageText;

//    private final Message message = new Message();
    private List<Message> messages = new Vector<Message>();

    @Inject
    private MessageService messageService;


    @PostConstruct
    public void init(){
        try{
//            messageText = "";
            messages = messageService.getMessages();
        } catch (Exception e){
            logger.severe("failed to load messages exception: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Failed to load messages", null));
        }
        logger.warning("this is the init with @postconstruct");
    }

    public void submit(){   // submit function for the simple input field
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
            Message newMesssage = new Message();
            newMesssage.setText(messageText);
            messageService.create(newMesssage);
            messages.add(newMesssage);
            logger.warning("message submitted: " + newMesssage.getText());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_INFO, "Message added successfully.", null));
        } catch (Exception e){
            logger.severe("failed to create message exception: "+e.getMessage());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message creation failed.", null));
        } finally {
            messageText = "";
        }
    }

    public void deleteMessage(Message message){
        controllerID = String.valueOf(this);
        try {
            messageService.delete(message);
            messages.remove(message);
            logger.warning( message.getId()+"deleted message: " + message.getText());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_INFO, "Message deleted successfully.", null));
        } catch (Exception e){
            logger.severe("failed to delete message exceptio: "+e.getMessage());
            FacesContext.getCurrentInstance().addMessage("submitstatus", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message deletion failed.", null));
        }
    }



    public String getControllerID() {
        return controllerID;
    }


    public List<Message> getMessages() {
        return messages;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
