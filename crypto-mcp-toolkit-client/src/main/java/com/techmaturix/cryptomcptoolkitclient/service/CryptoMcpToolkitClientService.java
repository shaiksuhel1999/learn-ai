package com.techmaturix.cryptomcptoolkitclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.modelcontextprotocol.client.McpAsyncClient;

@Service
public class CryptoMcpToolkitClientService {

	@Autowired
	private List<McpAsyncClient> mcpAsyncClients;

	public void callServers() {

		for (McpAsyncClient client : mcpAsyncClients) {
			
			client.listTools()
		    .subscribe(result -> {
		        result.tools().forEach(tool -> {
		            System.out.println("Tool Name: " + tool.name());
		            System.out.println("Description: " + tool.description());
		        });
		    });
			System.out.println("Client: " + client.getClientInfo().name());

			
		}
	}
}
