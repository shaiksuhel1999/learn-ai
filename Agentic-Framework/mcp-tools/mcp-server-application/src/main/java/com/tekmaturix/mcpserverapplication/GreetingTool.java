package com.tekmaturix.mcpserverapplication;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class GreetingTool {
	
	 @Tool(name = "greetUser", description = "Returns a greeting message for a given name")
	 public String greet(String name) {
	        return "Hello, " + name + "! Welcome to Spring AI MCP.";
	    }

}
