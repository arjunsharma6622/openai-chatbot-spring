package dev.arjunsharma.openaichatbot.dto;

public class Choice {
    private Message message;

    public Choice(Message message) {
        this.message = message;
    }

    public Choice() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
