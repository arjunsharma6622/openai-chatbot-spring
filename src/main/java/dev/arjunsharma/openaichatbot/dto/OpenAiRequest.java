package dev.arjunsharma.openaichatbot.dto;

import java.util.List;

public class OpenAiRequest {
    private String model;
    private List<RequestBodyMessage> messages;

    public OpenAiRequest(String model, List<RequestBodyMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

    public OpenAiRequest() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<RequestBodyMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<RequestBodyMessage> messages) {
        this.messages = messages;
    }
}
