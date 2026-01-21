package com.techmaturix.cryptomcptoolkitserver.service;

import java.io.IOException;

public interface CoinPaprikoService {

	/// Global And Market Data

	public String getGlobalMarketData() throws IOException, InterruptedException;

	public String getAllActiveTickers() throws IOException, InterruptedException;

	public String getTickerByCoinId(String coinId) throws IOException, InterruptedException;

	public String getTickerHistoricalData(String coinId, String startDate, String interval) throws IOException, InterruptedException;

	/// Coins

	public String getAllCoins() throws IOException, InterruptedException;

	public String getCoinById(String coinId) throws IOException, InterruptedException;

	public String getCoinTweets(String coinId) throws IOException, InterruptedException;

	public String getCoinEvents(String coinId) throws IOException, InterruptedException;

	public String getCoinExchanges(String coinId) throws IOException, InterruptedException;

	public String getCoinMarkets(String coinId) throws IOException, InterruptedException;

	/// OHLCV
	public String getLatestOhlcv(String coinId) throws IOException, InterruptedException;

	public String getTodayOhlcv(String coinId) throws IOException, InterruptedException;

	public String getHistoricalOhlcv(String coinId, String startDate, String endDate) throws IOException, InterruptedException;

	/// People

	public String getPersonById(String personId) throws IOException, InterruptedException;

	/// Tags

	public String getAllTags() throws IOException, InterruptedException;

	public String getCoinsByTag(String tagId, String query) throws IOException, InterruptedException;

	/// Exchanges

	public String getAllExchanges() throws IOException, InterruptedException;

	public String getExchangeById(String exchangeId) throws IOException, InterruptedException;

	public String getExchangeMarkets(String exchangeId) throws IOException, InterruptedException;

	/// Contracts

	public String getAllContractPlatforms() throws IOException, InterruptedException;

	public String getContractPlatformById(String platformId) throws IOException, InterruptedException;

	public String getTickerByContract(String platformId, String contractAddress) throws IOException, InterruptedException;

	public String getContractHistoricalTicker(String platformId, String contractAddress, String startDate,
			String interval) throws IOException, InterruptedException;

	/// Search

	public String searchCoins(String query) throws IOException, InterruptedException;

	/// Price Conversion

	public String convertPrice(String baseCurrencyId, String quoteCurrencyId, double amount) throws IOException, InterruptedException;

}
