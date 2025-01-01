package dev.arjunsharma.openaichatbot.controllers;

import dev.arjunsharma.openaichatbot.dto.AnswerDTO;
import dev.arjunsharma.openaichatbot.dto.QuestionDTO;
import dev.arjunsharma.openaichatbot.service.ChatBotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatbotController {

    ChatBotService chatBotService;

    public ChatbotController(ChatBotService chatBotService){
        this.chatBotService = chatBotService;
    }

    @PostMapping("/chat")
    ResponseEntity<AnswerDTO> chatWithOpenAiBot(@RequestBody QuestionDTO questionDTO){
        AnswerDTO aiResponse = chatBotService.chatWithOpenAiService(questionDTO.getQuestion());

        ResponseEntity<AnswerDTO> res;
        res = new ResponseEntity<>(aiResponse, HttpStatus.OK);

        return res;
    }
}
