package com.tekmaturix.cryptomcptoolkitservertwo.configuration;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tekmaturix.cryptomcptoolkitservertwo.service.CoinGeCkoServiceImpl;

@Configuration
public class CryptoMcpToolkitServerConfiguration {
	
	@Bean
	public ToolCallbackProvider toolCallbackProvider(CoinGeCkoServiceImpl coingeCkoServiceImpl) {
		return MethodToolCallbackProvider.builder()
				.toolObjects(coingeCkoServiceImpl)
				.build();
	}

}
