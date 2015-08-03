package com.baqir.gbce.trade;

import java.util.Date;
import java.util.List;

import com.baqir.gbce.stocks.SimpleStock;
import com.baqir.gbce.trade.SimpleStockTradeRecord.BuySellIndecator;
import com.baqir.gbce.traderecord.SimpleStockTradingDatabse;

public class SimpleStockTradeHandler {
	
	public void recordTrade(SimpleStock stock, int quantity, double tradePrice, boolean sell){
		
		
		SimpleStockTradeRecord record = new SimpleStockTradeRecord();
		record.setStock(stock);
		record.setQuantity(quantity);
		record.setTimeStamp(new Date());
		record.setTradePrice(tradePrice);
		record.setBuySellIndecator(sell?BuySellIndecator.SELL:BuySellIndecator.BUY);
		
		SimpleStockTradingDatabse database = SimpleStockTradingDatabse.getTradingDatabase();
		database.addTradeRecord(record);
		
	}
	
	public double calculateVolumeWeightedStockPrice(SimpleStock stock){
		
		double volumeWeightedStockPrice = 0.0;
		
		SimpleStockTradingDatabse database = SimpleStockTradingDatabse.getTradingDatabase();
		List<SimpleStockTradeRecord> tradeRecords = database.last15MinutesTradeRecords(stock.getSymbol());
		
		double tradeValue = 0;
		double totalTradeValue = 0;
		int totalQuantity = 0;
		
		for (SimpleStockTradeRecord tradeRecord : tradeRecords) {
			
			tradeValue = tradeRecord.getTradePrice() * tradeRecord.getQuantity();
			
			totalTradeValue += tradeValue;
			
			totalQuantity += tradeRecord.getQuantity();
			
		}
		
		try{
			volumeWeightedStockPrice = totalTradeValue / totalQuantity;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return volumeWeightedStockPrice;
		
	}
	
	public double caculateGeomatricMeanAllPrices(){
		
		double gm = 1.0;
		
		SimpleStockTradingDatabse database = SimpleStockTradingDatabse.getTradingDatabase();
		List<SimpleStockTradeRecord> tradeRecords = database.getTradeRecords();
		
		double count = 0.0;
		for (SimpleStockTradeRecord tradeRecord : tradeRecords) {
			gm *= tradeRecord.getTradePrice();
			++count;
		}
		
		gm = Math.pow(gm, 1.0/count);
		
		return gm;
	}

}
