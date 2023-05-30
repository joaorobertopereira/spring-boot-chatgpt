package br.com.helpc.springbootchatgpt.model.rsponse;

import java.util.List;

public record ChatGPTResponse(List<Choice> choices) {

}
