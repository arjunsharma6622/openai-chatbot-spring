package dev.arjunsharma.openaichatbot.dto;

public class RequestBodyMessage {
    private String role;
    private String content;

    public RequestBodyMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public RequestBodyMessage() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
