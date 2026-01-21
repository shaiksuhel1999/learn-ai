package com.techmaturix.cryptomcptoolkitserver.constants;

public class CoinPaprikaApiConstants {

	public final static String BASE_COIN_PAPRIKE_URL = "https://api.coinpaprika.com/v1/";

	public final static String COIN_PAPRIKE_GLOBAL_MARKET_DATA = "global";

	public final static String COIN_PAPRIKE_COIN_LIST = "coins";

	public final static String COIN_PAPRIKE_COIN_BY_ID = "coins/{id}";

	public final static String COIN_PAPRIKE_COIN_TWEETS_BY_ID = "coins/{id}/twitter";

	public final static String COIN_PAPRIKE_EVENTS_COIN_BY_ID = "coins/{id}/events";

	public final static String COIN_PAPRIKE_EXCHANGE_BY_COIN_ID = "coins/{id}/exchanges";

	public final static String COIN_PAPRIKE_MARKETS_BY_COIN_ID = "coins/{id}/markets";

	public final static String COIN_PAPRIKE_OHLCV_BY_COIN_ID = "coins/{id}/ohlcv/latest";

	public final static String COIN_PAPRIKE_OHLCV_HISTORICAL = "coins/{id}/ohlcv/historical?start={start_date}&end={end_date}";

	public final static String COIN_PAPRIKE_OHLCV_TODAY = "coins/{id}/ohlcv/today";

	public final static String COIN_PAPRIKE_PERSON_BY_ID = "people/{person_id}";

	public final static String COIN_PAPRIKE_CRYPTO_TAGS = "tags";

	public final static String COIN_PAPRIKE_CRYPTO_TAGS_BY_ID = "tags/{tag_id}/{query}";

	public final static String COIN_PAPRIKE_ACTIVE_COINS = "tickers";

	public final static String COIN_PAPRIKE_SPECIFIC_COINS = "tickers/{id}";

	public final static String COIN_PAPRIKE_HOSTORIC_SPECIFIC_COINS = "tickers/{id}/historical?start={start_date}&interval={interval}";

	public final static String COIN_PAPRIKE_EXCHAGES = "exchanges";

	public final static String COIN_PAPRIKE_EXCHAGES_BY_ID = "exhanges/{exchange_id}";

	public final static String COIN_PAPRIKE_LIST_EXCHANGE_MARKET = "exchanges/{exchange_id}/markets";

	public final static String COIN_PAPRIKE_CONTRACT_PLATFORMS = "contracts";

	public final static String COIN_PAPRIKE_CONTRACT_PLATFORMS_BY_ID = "contracts/{platform_id}";

	public final static String COIN_PAPRIKE_REDIRECT_TICKER_BY_ADDRESS = "contracts/{platform_id}/{contract_address}";

	public final static String COIN_PAPRIKE_REDIRECT_HISTORICAL_TICKER_BY_ADDRESS = "contracts/{platform_id}/{contract_address}/historical?start={start_date}&interval={interval}";

	public final static String COIN_PAPRIKE_SEARCH = "search?{query}";

	public final static String COIN_PAPRIKE_PRICE_CONVERTER = "price-converter?base_currency_id={base_currency_id}&quote_currency_id={quote_currency_id}&amount={amount}";

}
