package com.tekmaturix.mcpserverapplication;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider toolCallbackProvider(GreetingTool greetingTool) {
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(greetingTool)
                .build();
    }
}