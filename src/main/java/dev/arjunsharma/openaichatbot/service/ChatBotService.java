package dev.arjunsharma.openaichatbot.service;

import dev.arjunsharma.openaichatbot.dto.AnswerDTO;
import dev.arjunsharma.openaichatbot.dto.OpenAiRequest;
import dev.arjunsharma.openaichatbot.dto.OpenAiResponse;
import dev.arjunsharma.openaichatbot.dto.RequestBodyMessage;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatBotService {

    final RestTemplate restTemplate;

    public ChatBotService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AnswerDTO chatWithOpenAiService(String question){
        OpenAiRequest openAiRequestBody;
        openAiRequestBody = new OpenAiRequest();

        List<RequestBodyMessage> messages = getRequestBodyMessages(question);

        // adding data to req body
        openAiRequestBody.setModel("gpt-4o");
        openAiRequestBody.setMessages(messages);

        // adding the headers data
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // here add your openai api key, if this is not there then the openai requests won't work
        headers.set("Authorization", "Bearer " + "Your_Openai_API_KEY");

        // create HTTPEntity
        HttpEntity<OpenAiRequest> req = new HttpEntity<>(openAiRequestBody, headers);


        OpenAiResponse res = restTemplate.postForObject(
                "https://api.openai.com/v1/chat/completions",
                req,
                OpenAiResponse.class
        );

        AnswerDTO answer;
        answer = new AnswerDTO();

        answer.setAnswer(
                res.getChoices().get(0).getMessage().getContent()
        );

        return answer;
    }


    private List<RequestBodyMessage> getRequestBodyMessages(String question) {
        List<RequestBodyMessage> messages = new ArrayList<>();

        RequestBodyMessage developerMessage = new RequestBodyMessage(
                "developer",
                "You are a helpful assistant. The user will ask only one question. " +
                        "Answer it in maybe 500 words or more if required without any formatting, line breaks, or special characters. " +
                        "Keep the response plain and concise."
        );

        RequestBodyMessage userMessage = new RequestBodyMessage(
                "user",
                " " + question
        );

        messages.add(developerMessage);
        messages.add(userMessage);
        return messages;
    }
}
