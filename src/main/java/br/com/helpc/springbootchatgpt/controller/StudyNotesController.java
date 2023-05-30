package br.com.helpc.springbootchatgpt.controller;

import br.com.helpc.springbootchatgpt.model.rsponse.ChatGPTResponse;
import br.com.helpc.springbootchatgpt.model.rsponse.Choice;
import br.com.helpc.springbootchatgpt.service.StudyNotesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/chatGPT")
public class StudyNotesController {

    private final StudyNotesService service;

    public StudyNotesController(StudyNotesService service) {
        this.service = service;
    }

    @PostMapping("/study-notes")
    public Mono<Choice> createStudyNotes(@RequestBody String topic) {
        return service.createStudyNotes(topic).map(response -> response.choices().get(0));
    }
}
