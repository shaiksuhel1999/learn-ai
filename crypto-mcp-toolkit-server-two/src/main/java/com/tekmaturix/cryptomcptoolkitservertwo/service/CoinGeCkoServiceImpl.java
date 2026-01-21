package com.tekmaturix.cryptomcptoolkitservertwo.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import com.tekmaturix.cryptomcptoolkitservertwo.constants.CoinGeCkoApiConstants;

@Service
public class CoinGeCkoServiceImpl implements CoinGeCkoService {

    private HttpResponse<String> execute(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .build();

        return HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    private String joinIds(List<String> ids) {
        StringJoiner joiner = new StringJoiner(",");
        ids.forEach(joiner::add);
        return joiner.toString();
    }

    /* -------------------- BASIC -------------------- */

    @Override
    @Tool(name = "checkCoinGeckoApiHealth", description = "Checks whether the CoinGecko API service is up and running.")
    public HttpResponse<String> checkApiHealth() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_HEALTH_CHECK);
    }

    @Override
    @Tool(name = "getSupportedVsCurrencies", description = "Returns all supported vs_currencies.")
    public HttpResponse<String> getSupportedVsCurrencies() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_SUPPORTED_VS_CURRENCIES);
    }

    @Override
    @Tool(name = "getTrendingCoins", description = "Returns trending cryptocurrencies.")
    public HttpResponse<String> getTrendingCoins() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_TRENDING);
    }

    @Override
    @Tool(name = "getGlobalCryptoMarketData", description = "Returns global crypto market data.")
    public HttpResponse<String> getGlobalMarketData() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_GLOBAL_CRYPTO_MARKET_DATA);
    }

    @Override
    @Tool(name = "getGlobalDefiMarketData", description = "Returns global DeFi market data.")
    public HttpResponse<String> getGlobalDefiMarketData() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_GLOBAL_DEFI_MARKET_DATA);
    }

    /* -------------------- MARKETS -------------------- */

    @Override
    @Tool(name = "getAssetPlatforms", description = "Returns supported blockchain platforms.")
    public HttpResponse<String> getAssetPlatforms() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_ASSET_PLATFORMS);
    }

    @Override
    @Tool(name = "getExchangeRates", description = "Returns crypto and fiat exchange rates.")
    public HttpResponse<String> getExchangeRates() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_EXCHANGE_RATES);
    }

    @Override
    @Tool(name = "getSimplePrice", description = "Returns simple price data for crypto IDs.")
    public HttpResponse<String> getSimplePrice(
            @ToolParam(required = true) List<String> cryptoIds,
            @ToolParam(required = true) String vsCurrency)
            throws IOException, InterruptedException {

        String url = CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_SIMPLE_PRICE
                        .replace("{crypto_ids}", joinIds(cryptoIds))
                        .replace("{currency_type}", vsCurrency);

        return execute(url);
    }

    @Override
    @Tool(name = "getAllCoins", description = "Returns all supported coins.")
    public HttpResponse<String> getAllCoins() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_COINS_LIST);
    }

    @Override
    @Tool(name = "getCoinMetadataById", description = "Returns coin metadata.")
    public HttpResponse<String> getCoinById(
            @ToolParam(required = true) String coinId)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_COIN_METADATA_BY_ID
                        .replace("{id}", coinId));
    }

    @Override
    @Tool(name = "getCoinTickers", description = "Returns exchange tickers for a coin.")
    public HttpResponse<String> getCoinTickers(
            @ToolParam(required = true) String coinId)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_COIN_TICKERS
                        .replace("{id}", coinId));
    }

    @Override
    @Tool(name = "getCoinHistoryByDate", description = "Returns coin price on a specific date.")
    public HttpResponse<String> getCoinHistoryByDate(
            @ToolParam(required = true) String coinId,
            @ToolParam(required = true) String date)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_COIN_HISTORY_SPECIFIC_DATE
                        .replace("{id}", coinId)
                        .replace("{date}", date));
    }

    @Override
    @Tool(name = "getCoinMarketChart", description = "Returns historical market chart.")
    public HttpResponse<String> getCoinMarketChart(
            String coinId, String vsCurrency, int days)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_COIN_HISTORY_CHART
                        .replace("{id}", coinId)
                        .replace("{currency_type}", vsCurrency)
                        .replace("{days}", String.valueOf(days)));
    }

    @Override
    @Tool(name = "getCoinsMarketData", description = "Returns paginated market data.")
    public HttpResponse<String> getCoinsMarketData(
            String vsCurrency, String order, int perPage, int page)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_COINS_MARKET_PRICE_DATA
                        .replace("{currency_type}", vsCurrency)
                        .replace("{order_value}", order)
                        .replace("{per_page_value}", String.valueOf(perPage))
                        .replace("{page_no}", String.valueOf(page)));
    }

    /* -------------------- EXCHANGES -------------------- */

    @Override
    public HttpResponse<String> getAllExchanges() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_EXCHAGES);
    }

    @Override
    public HttpResponse<String> getExchangesList() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_EXCHAGES_LIST);
    }

    @Override
    public HttpResponse<String> getBinanceTickers() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_EXCHAGES_TICKER_DATA);
    }

    @Override
    public HttpResponse<String> getBinanceVolumeChart(int days)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_EXCHAGES_HISTORIC_VOLUME_CHART
                        .replace("{days}", String.valueOf(days)));
    }

    /* -------------------- DERIVATIVES / NFT / ENTITIES -------------------- */

    @Override
    public HttpResponse<String> getAllDerivatives() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_DERIVATIVES);
    }

    @Override
    public HttpResponse<String> getDerivativeExchanges() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_DERIVATIVE_EXCHAGES);
    }

    @Override
    public HttpResponse<String> getAllNfts() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_NFT_COLLECTION);
    }

    @Override
    public HttpResponse<String> getNftById(String nftId)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_NFT_DETAILS
                        .replace("{id}", nftId));
    }

    @Override
    public HttpResponse<String> getNftContractDetails(String nftId, String contractAddress)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_NFT_CONTRACT
                        .replace("{id}", nftId)
                        .replace("{address}", contractAddress));
    }

    @Override
    public HttpResponse<String> getAllEntities() throws IOException, InterruptedException {
        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_ENTITY_LIST);
    }

    @Override
    public HttpResponse<String> getEntityHoldings(String entityId)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_ENTITY_CRYPTO_HOLDINGS
                        .replace("{entity_id}", entityId));
    }

    @Override
    public HttpResponse<String> getEntityHoldingChart(String entityId, String coinId)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_ENTITY_CRYPTO_HOLDINGS_CHART
                        .replace("{entity_id}", entityId)
                        .replace("{coin_id}", coinId));
    }

    @Override
    public HttpResponse<String> getEntityTransactionHistory(String entityId)
            throws IOException, InterruptedException {

        return execute(CoinGeCkoApiConstants.COINGECKO_BASE_URL +
                CoinGeCkoApiConstants.COINGECKO_ENTITY_TRANSACTION_HISTORY
                        .replace("{entity_id}", entityId));
    }
}
