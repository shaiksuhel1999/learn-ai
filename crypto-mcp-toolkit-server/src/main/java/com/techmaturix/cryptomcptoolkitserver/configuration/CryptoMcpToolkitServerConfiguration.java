package com.techmaturix.cryptomcptoolkitserver.configuration;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techmaturix.cryptomcptoolkitserver.service.CoinPaprikoServiceImpl;

@Configuration
public class CryptoMcpToolkitServerConfiguration {
	
	@Bean
	public ToolCallbackProvider toolCallbackProvider(CoinPaprikoServiceImpl coinPaprikoServiceImpl) {
		return MethodToolCallbackProvider
				.builder()
				.toolObjects(coinPaprikoServiceImpl)
				.build();
	}

}
