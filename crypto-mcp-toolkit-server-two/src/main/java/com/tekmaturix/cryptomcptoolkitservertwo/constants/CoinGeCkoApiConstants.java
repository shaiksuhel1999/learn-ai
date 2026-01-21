package com.tekmaturix.cryptomcptoolkitservertwo.constants;

public class CoinGeCkoApiConstants {

	public final static String COINGECKO_BASE_URL = "https://api.coingecko.com/api/v3/";

	public final static String COINGECKO_HEALTH_CHECK = "ping";

	public final static String COINGECKO_SUPPORTED_VS_CURRENCIES = "simple/supported_vs_currencies";

	public final static String COINGECKO_TRENDING = "search/trending";

	public final static String COINGECKO_GLOBAL_CRYPTO_MARKET_DATA = "global";

	public final static String COINGECKO_GLOBAL_DEFI_MARKET_DATA = "global/decentralized_finance_defi";

	public final static String COINGECKO_ASSET_PLATFORMS = "asset_platforms";

	public final static String COINGECKO_EXCHANGE_RATES = "exchange_rates";

	public final static String COINGECKO_SIMPLE_PRICE = "simple/price?ids={crypto_ids}&vs_currencies={currency_type}";

	public final static String COINGECKO_COINS_LIST = "coins/list";

	public final static String COINGECKO_COINS_MARKET_PRICE_DATA = "coins/markets?vs_currency={currency_type}&order={order_value}&per_page={per_page_value}&page={page_no}";

	public final static String COINGECKO_COIN_METADATA_BY_ID = "coins/{id}";

	public final static String COINGECKO_COIN_TICKERS = "coins/{id}/tickers";

	public final static String COINGECKO_COIN_HISTORY_SPECIFIC_DATE = "coins/{id}/history?date={date}";

	public final static String COINGECKO_COIN_HISTORY_CHART = "coins/{id}/market_chart?vs_currency={currency_type}&days={days}";

	public final static String COINGECKO_EXCHAGES = "exchanges";

	public final static String COINGECKO_EXCHAGES_LIST = "exchanges/list";

	public final static String COINGECKO_EXCHAGES_TICKER_DATA = "exchanges/binance/tickers";

	public final static String COINGECKO_EXCHAGES_HISTORIC_VOLUME_CHART = "exchanges/binance/volume_chart?days={days}";

	public final static String COINGECKO_DERIVATIVES = "derivatives";

	public final static String COINGECKO_DERIVATIVE_EXCHAGES = "derivatives/exchanges";

	public final static String COINGECKO_NFT_COLLECTION = "nfts/list";

	public final static String COINGECKO_NFT_DETAILS = "nfts/{id}";

	public final static String COINGECKO_NFT_CONTRACT = "nfts/{id}/contract/{address}";

	public final static String COINGECKO_ENTITY_LIST = "entities/list";

	public final static String COINGECKO_ENTITY_CRYPTO_HOLDINGS = "public_treasury/{entity_id}";

	public final static String COINGECKO_ENTITY_CRYPTO_HOLDINGS_CHART = "public_treasury/{entity_id}/{coin_id}/holding_chart";

	public final static String COINGECKO_ENTITY_TRANSACTION_HISTORY = "public_treasury/{entity_id}/transaction_history";

}