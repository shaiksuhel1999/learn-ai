package com.techmaturix.cryptomcptoolkitclient.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CryptoMcpToolkitClientController {
	
	private final ChatClient cliChatClient;
	
	@Autowired
	public CryptoMcpToolkitClientController(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider) {
		super();
		this.cliChatClient = builder
				.defaultSystem("Please prioritise the context information for answering the questions")
				.defaultToolCallbacks(toolCallbackProvider)
				.build();
	}
	
	@GetMapping("/call")
	public String call(@RequestParam String query) {
		PromptTemplate prTem = new PromptTemplate(query);
		Prompt prompt = prTem.create();
		return cliChatClient.prompt(prompt).call().content();
	}

}
