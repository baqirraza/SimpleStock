package com.baqir.gbce.traderecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baqir.gbce.trade.SimpleStockTradeRecord;
import com.baqir.gbce.utils.SimpleStockUtils;

// Mocking the database entries here 
// to handle the trading
public class SimpleStockTradingDatabse {
	
	private static SimpleStockTradingDatabse instance;
	
	private List<SimpleStockTradeRecord> tradeRecords;
	
	private SimpleStockTradingDatabse(){
		tradeRecords = new ArrayList<>();
	}
	
	public static SimpleStockTradingDatabse getTradingDatabase(){
		if (instance == null)
			instance = new SimpleStockTradingDatabse();
		
		return instance;
	}

	public List<SimpleStockTradeRecord> getTradeRecords() {
		return tradeRecords;
	}

	public void addTradeRecord(SimpleStockTradeRecord tradeRecord) {
		this.tradeRecords.add(tradeRecord);
	}
	
	public void clear(){
		this.tradeRecords.clear();
	}


	public List<SimpleStockTradeRecord> last15MinutesTradeRecords(String stockSymbol){
		
		List<SimpleStockTradeRecord> filteredTradeRecords = new ArrayList<>();
		
		Date filterDate = SimpleStockUtils.get15MinuteEarlierDate();
		
		
		for (SimpleStockTradeRecord tradeRecord : tradeRecords) {
			
			// We don't need any records earlier than 15 minutes
			if(tradeRecord.getTimeStamp().before(filterDate))
				continue;
			
			// We only need trade records for the given stocks
			if(!tradeRecord.getStock().getSymbol().equals(stockSymbol))
				continue;
			
			filteredTradeRecords.add(tradeRecord);
		}
		
		return filteredTradeRecords;
	}
	
	

}
