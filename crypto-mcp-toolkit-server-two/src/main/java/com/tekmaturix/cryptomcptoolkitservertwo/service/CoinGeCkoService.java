package com.tekmaturix.cryptomcptoolkitservertwo.service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public interface CoinGeCkoService {

	/// System & Meta

	public HttpResponse<String> checkApiHealth() throws IOException, InterruptedException;

	public HttpResponse<String> getSupportedVsCurrencies() throws IOException, InterruptedException;

	/// Market & Trading

	public HttpResponse<String> getTrendingCoins() throws IOException, InterruptedException;

	public HttpResponse<String> getGlobalMarketData() throws IOException, InterruptedException;

	public HttpResponse<String> getGlobalDefiMarketData() throws IOException, InterruptedException;

	/// Platforms & Rates

	public HttpResponse<String> getAssetPlatforms() throws IOException, InterruptedException;

	public HttpResponse<String> getExchangeRates() throws IOException, InterruptedException;

	/// Simple Price

	public HttpResponse<String> getSimplePrice(List<String> cryptoIds, String vsCurrency) throws IOException, InterruptedException;

	/// Coins

	public HttpResponse<String> getAllCoins() throws IOException, InterruptedException;

	public HttpResponse<String> getCoinById(String coinId) throws IOException, InterruptedException;

	public HttpResponse<String> getCoinTickers(String coinId) throws IOException, InterruptedException;

	public HttpResponse<String> getCoinHistoryByDate(String coinId, String date) throws IOException, InterruptedException;

	public HttpResponse<String> getCoinMarketChart(String coinId, String vsCurrency, int days) throws IOException, InterruptedException;

	/// Market Prices (Paginated)

	public HttpResponse<String> getCoinsMarketData(String vsCurrency, String order, int perPage, int page) throws IOException, InterruptedException;

	/// Exchanges

	public HttpResponse<String> getAllExchanges() throws IOException, InterruptedException;

	public HttpResponse<String> getExchangesList() throws IOException, InterruptedException;

	public HttpResponse<String> getBinanceTickers() throws IOException, InterruptedException;

	public HttpResponse<String> getBinanceVolumeChart(int days) throws IOException, InterruptedException;

	/// Derivatives

	public HttpResponse<String> getAllDerivatives() throws IOException, InterruptedException;

	public HttpResponse<String> getDerivativeExchanges() throws IOException, InterruptedException;

	/// NFTs

	public HttpResponse<String> getAllNfts() throws IOException, InterruptedException;

	public HttpResponse<String> getNftById(String nftId) throws IOException, InterruptedException;

	public HttpResponse<String> getNftContractDetails(String nftId, String contractAddress) throws IOException, InterruptedException;

	/// Public Treasury / Entities

	public HttpResponse<String> getAllEntities() throws IOException, InterruptedException;

	public HttpResponse<String> getEntityHoldings(String entityId) throws IOException, InterruptedException;

	public HttpResponse<String> getEntityHoldingChart(String entityId, String coinId) throws IOException, InterruptedException;

	public HttpResponse<String> getEntityTransactionHistory(String entityId) throws IOException, InterruptedException;

}
