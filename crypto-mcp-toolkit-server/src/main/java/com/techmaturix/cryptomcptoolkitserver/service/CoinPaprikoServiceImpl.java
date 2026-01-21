package com.techmaturix.cryptomcptoolkitserver.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import com.techmaturix.cryptomcptoolkitserver.constants.CoinPaprikaApiConstants;


@Service
public class CoinPaprikoServiceImpl implements CoinPaprikoService {

	private String execute(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .build();
        
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
	
    @Override
    @Tool(
        name = "getGlobalMarketData",
        description = "Fetches overall global cryptocurrency market statistics such as total market cap, volume, and Bitcoin dominance from CoinPaprika."
    )
    public String getGlobalMarketData() throws IOException, InterruptedException {
    	return execute(CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_GLOBAL_MARKET_DATA);
    }

    @Override
    @Tool(
        name = "getAllActiveTickers",
        description = "Returns a list of all active cryptocurrency tickers with real-time price, volume, and market data."
    )
    public String getAllActiveTickers() throws IOException, InterruptedException {
    	return execute(CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_ACTIVE_COINS);
    }

    @Override
    @Tool(
        name = "getTickerByCoinId",
        description = "Fetches detailed ticker information including price, volume, and market stats for a specific cryptocurrency."
    )
    public String getTickerByCoinId(
        @ToolParam(required = true, description = "Unique CoinPaprika coin ID such as 'btc-bitcoin' or 'eth-ethereum'")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_SPECIFIC_COINS.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getTickerHistoricalData",
        description = "Retrieves historical ticker price data for a specific cryptocurrency based on time interval."
    )
    public String getTickerHistoricalData(
        @ToolParam(required = true, description = "CoinPaprika coin ID (example: btc-bitcoin)")
        String coinId,
        @ToolParam(required = true, description = "Start date in ISO format (yyyy-MM-dd)")
        String startDate,
        @ToolParam(required = true, description = "Time interval such as '1d', '1h', or '5m'")
        String interval) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_HOSTORIC_SPECIFIC_COINS
                        .replace("{id}", coinId)
                        .replace("{start_date}", startDate)
                        .replace("{interval}", interval);

        return execute(url);
    }

    @Override
    @Tool(
        name = "getAllCoins",
        description = "Returns a complete list of all cryptocurrencies supported by CoinPaprika."
    )
    public String getAllCoins() throws IOException, InterruptedException {
    	return execute(CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_COIN_LIST);
    }

    @Override
    @Tool(
        name = "getCoinById",
        description = "Fetches detailed metadata about a specific cryptocurrency such as description, rank, team, and supply."
    )
    public String getCoinById(
        @ToolParam(required = true, description = "CoinPaprika coin ID such as btc-bitcoin")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_COIN_BY_ID.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getCoinTweets",
        description = "Returns the latest tweets related to a specific cryptocurrency from CoinPaprika."
    )
    public String getCoinTweets(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_COIN_TWEETS_BY_ID.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getCoinEvents",
        description = "Fetches upcoming and past events related to a specific cryptocurrency."
    )
    public String getCoinEvents(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_EVENTS_COIN_BY_ID.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getCoinExchanges",
        description = "Lists all exchanges where a specific cryptocurrency is traded."
    )
    public String getCoinExchanges(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_EXCHANGE_BY_COIN_ID.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getCoinMarkets",
        description = "Returns all market pairs and trading platforms for a specific cryptocurrency."
    )
    public String getCoinMarkets(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_MARKETS_BY_COIN_ID.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getLatestOhlcv",
        description = "Fetches the latest OHLCV (Open, High, Low, Close, Volume) market data for a coin."
    )
    public String getLatestOhlcv(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_OHLCV_BY_COIN_ID.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getTodayOhlcv",
        description = "Fetches today's OHLCV trading data for a cryptocurrency."
    )
    public String getTodayOhlcv(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_OHLCV_TODAY.replace("{id}", coinId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getHistoricalOhlcv",
        description = "Fetches historical OHLCV data for a cryptocurrency between two dates."
    )
    public String getHistoricalOhlcv(
        @ToolParam(required = true, description = "CoinPaprika coin ID")
        String coinId,
        @ToolParam(required = true, description = "Start date in yyyy-MM-dd format")
        String startDate,
        @ToolParam(required = true, description = "End date in yyyy-MM-dd format")
        String endDate) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_OHLCV_HISTORICAL
                        .replace("{id}", coinId)
                        .replace("{start_date}", startDate)
                        .replace("{end_date}", endDate);

        return execute(url);
    }

    @Override
    @Tool(
        name = "getPersonById",
        description = "Fetches information about a crypto founder, investor, or influencer by ID."
    )
    public String getPersonById(
        @ToolParam(required = true, description = "CoinPaprika person ID")
        String personId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_PERSON_BY_ID.replace("{person_id}", personId);
    	return execute(url);
    	
    }

    @Override
    @Tool(
        name = "getAllTags",
        description = "Returns all cryptocurrency tags such as DeFi, NFT, Layer 1, Metaverse, etc."
    )
    public String getAllTags() throws IOException, InterruptedException {
    	return execute(CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_CRYPTO_TAGS);
    }

    @Override
    @Tool(
        name = "getCoinsByTag",
        description = "Fetches cryptocurrencies filtered by a specific tag and category."
    )
    public String getCoinsByTag(
        @ToolParam(required = true, description = "Tag ID such as 'defi' or 'nft'")
        String tagId,
        @ToolParam(required = true, description = "Query type such as 'coins' or 'icos'")
        String query) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_CRYPTO_TAGS_BY_ID
                        .replace("{tag_id}", tagId)
                        .replace("{query}", query == null ? "" : query);
        return execute(url);
    }

    @Override
    @Tool(
        name = "getAllExchanges",
        description = "Returns a list of all cryptocurrency exchanges tracked by CoinPaprika."
    )
    public String getAllExchanges() throws IOException, InterruptedException {
    	return execute(CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_EXCHAGES);
    }

    @Override
    @Tool(
        name = "getExchangeById",
        description = "Fetches detailed information about a specific cryptocurrency exchange."
    )
    public String getExchangeById(
        @ToolParam(required = true, description = "CoinPaprika exchange ID such as 'binance'")
        String exchangeId) throws IOException, InterruptedException {
        String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_EXCHAGES_BY_ID.replace("{exchange_id}", exchangeId);
        return execute(url);
    }

    @Override
    @Tool(
        name = "getExchangeMarkets",
        description = "Returns all trading markets available on a specific exchange."
    )
    public String getExchangeMarkets(
        @ToolParam(required = true, description = "CoinPaprika exchange ID")
        String exchangeId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_LIST_EXCHANGE_MARKET.replace("{exchange_id}", exchangeId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getAllContractPlatforms",
        description = "Returns all supported blockchain platforms such as Ethereum, BSC, Solana."
    )
    public String getAllContractPlatforms() throws IOException, InterruptedException {
    	return execute(CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_CONTRACT_PLATFORMS);
    }

    @Override
    @Tool(
        name = "getContractPlatformById",
        description = "Fetches information about a specific blockchain contract platform."
    )
    public String getContractPlatformById(
        @ToolParam(required = true, description = "Platform ID such as 'ethereum'")
        String platformId) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_CONTRACT_PLATFORMS_BY_ID.replace("{platform_id}", platformId);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "getTickerByContract",
        description = "Fetches ticker data for a token using its blockchain platform and contract address."
    )
    public String getTickerByContract(
        @ToolParam(required = true, description = "Blockchain platform ID like 'ethereum'")
        String platformId,
        @ToolParam(required = true, description = "Smart contract address of the token")
        String contractAddress) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_REDIRECT_TICKER_BY_ADDRESS
                        .replace("{platform_id}", platformId)
                        .replace("{contract_address}", contractAddress);

        return execute(url);
    }

    @Override
    @Tool(
        name = "getContractHistoricalTicker",
        description = "Fetches historical price data of a token using its smart contract address."
    )
    public String getContractHistoricalTicker(
        @ToolParam(required = true, description = "Blockchain platform ID")
        String platformId,
        @ToolParam(required = true, description = "Smart contract address")
        String contractAddress,
        @ToolParam(required = true, description = "Start date in yyyy-MM-dd format")
        String startDate,
        @ToolParam(required = true, description = "Time interval like '1d', '1h'")
        String interval) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_REDIRECT_HISTORICAL_TICKER_BY_ADDRESS
                        .replace("{platform_id}", platformId)
                        .replace("{contract_address}", contractAddress)
                        .replace("{start_date}", startDate)
                        .replace("{interval}", interval);

        return execute(url);
    }

    @Override
    @Tool(
        name = "searchCoins",
        description = "Searches cryptocurrencies, tags, and exchanges using a keyword."
    )
    public String searchCoins(
        @ToolParam(required = true, description = "Search keyword such as 'bitcoin' or 'defi'")
        String query) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_SEARCH.replace("{query}", "q=" + query);
    	return execute(url);
    }

    @Override
    @Tool(
        name = "convertPrice",
        description = "Converts a crypto amount from one currency to another using real-time price data."
    )
    public String convertPrice(
        @ToolParam(required = true, description = "Base currency ID like 'btc-bitcoin'")
        String baseCurrencyId,
        @ToolParam(required = true, description = "Quote currency ID like 'usd-us-dollars'")
        String quoteCurrencyId,
        @ToolParam(required = true, description = "Amount to convert")
        double amount) throws IOException, InterruptedException {
    	String url = CoinPaprikaApiConstants.BASE_COIN_PAPRIKE_URL +
                CoinPaprikaApiConstants.COIN_PAPRIKE_PRICE_CONVERTER
                        .replace("{base_currency_id}", baseCurrencyId)
                        .replace("{quote_currency_id}", quoteCurrencyId)
                        .replace("{amount}", String.valueOf(amount));

        return execute(url);
    }
}
