package com.baqir.gbce;

import com.baqir.gbce.stocks.SimpleStock;
import com.baqir.gbce.stocks.SimpleStocksFactory;
import com.baqir.gbce.trade.SimpleStockTradeHandler;

public class SimpleStocksCalculator {
	
	private static SimpleStocksCalculator instance;
	
	private SimpleStocksCalculator(){}
	
	public static SimpleStocksCalculator creatStocksCalculator(){
		
		if(instance == null)
			instance = new SimpleStocksCalculator();
		
		return instance;
		
	}
	
	
	public double calculateDividendYield(String stockSymbol, double marketPrice){
		
		double yeild = 0.0;
		
		SimpleStock stocks = SimpleStocksFactory.getSimpleStock(stockSymbol);
		
		yeild = stocks.calculateDividendYeild(marketPrice);
	
		return yeild;
		
	}
	
	public double calculatePERatio(String stockSymbol, double marketPrice){
		
		double peRatio = 0.0;
		
		SimpleStock stocks = SimpleStocksFactory.getSimpleStock(stockSymbol);
		
		peRatio = stocks.calculatePERatio(marketPrice);
		
		return peRatio;
		
	}
	
	public void recordTrade(String stockSymbol, double tradePrice, int quantity, boolean sell){
		
		SimpleStock stocks = SimpleStocksFactory.getSimpleStock(stockSymbol);
		
		SimpleStockTradeHandler tradeHandler = new SimpleStockTradeHandler();
		
		tradeHandler.recordTrade(stocks, quantity, tradePrice, sell);
		
	}
	
	public double calculateVolumeWeightedStockPrice(String stockSymbol){
		
		double weightedPrice = 0.0;
		
		SimpleStock stocks = SimpleStocksFactory.getSimpleStock(stockSymbol);
		
		SimpleStockTradeHandler tradeHandler = new SimpleStockTradeHandler();
		
		weightedPrice = tradeHandler.calculateVolumeWeightedStockPrice(stocks);
		
		return weightedPrice;
	}
	
	public double calculateAllShareIndex(){
		
		double allShareIndex=0.0;
		
		SimpleStockTradeHandler tradeHandler = new SimpleStockTradeHandler(); 
		
		allShareIndex = tradeHandler.caculateGeomatricMeanAllPrices();
		
		return allShareIndex;
	}
	
}
