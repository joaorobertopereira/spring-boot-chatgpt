package br.com.helpc.springbootchatgpt.service;

import br.com.helpc.springbootchatgpt.model.request.ChatGPTRequest;
import br.com.helpc.springbootchatgpt.model.rsponse.ChatGPTResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudyNotesService {

    private final WebClient webClient;

    public StudyNotesService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ChatGPTResponse> createStudyNotes(String topic) {
        ChatGPTRequest request = createStudyNotesRequest(topic);

        return webClient
            .post()
            .bodyValue(request)
            .retrieve()
            .bodyToMono(ChatGPTResponse.class);
    }

    private ChatGPTRequest createStudyNotesRequest(String topic) {

        String question = "Quais são os pontos chave que devo estudar sobre o seguinte assunto: " + topic;

        return new ChatGPTRequest(
                "text-davinci-003",
                question,
                0.3,
                2000,
                1.0,
                0.0,
                0.0);
    }

}