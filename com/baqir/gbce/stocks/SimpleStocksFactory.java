package com.baqir.gbce.stocks;

public class SimpleStocksFactory {
	
	private SimpleStocksFactory(){}
	
	public static SimpleStock getSimpleStock(String stockSymbol){
		
		if(SimpleStock.SYMBOL_ALE.equals(stockSymbol))
			return new SimpleStockALE();
		else if (SimpleStock.SYMBOL_GIN.equals(stockSymbol))
			return new SimpleStockGIN();
		else if (SimpleStock.SYMBOL_JOE.equals(stockSymbol))
			return new SimpleStockJOE();
		else if (SimpleStock.SYMBOL_POP.equals(stockSymbol))
			return new SimpleStockPOP();
		else if (SimpleStock.SYMBOL_TEA.equals(stockSymbol))
			return new SimpleStockTEA();
		else 
			return null;
		
		
	}

}
