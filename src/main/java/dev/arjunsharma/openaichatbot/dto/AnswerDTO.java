package dev.arjunsharma.openaichatbot.dto;

public class AnswerDTO {
    private String answer;

    public AnswerDTO(String answer) {
        this.answer = answer;
    }

    public AnswerDTO() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
