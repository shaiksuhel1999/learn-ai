package com.tekmaturix.mcpclientapplication;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DemoClientRunner implements CommandLineRunner {

	@Autowired
    private List<McpSyncClient> mcpSyncClients;

    @Override
    public void run(String... args) {
        if (mcpSyncClients.isEmpty()) {
            System.out.println("No MCP clients found.");
            return;
        }

        McpSyncClient client = mcpSyncClients.get(0);
        System.out.println("Connected to: " + client.getServerInfo());

        var tools = client.listTools();
        System.out.println("Tools: " + tools);

        var result = client.callTool(new CallToolRequest("greetUser", Map.of("name", "Shaik")));
        System.out.println("Tool Result: " + result);
    }
}