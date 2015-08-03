package com.baqir.gbce.stocks;

public class SimpleStockALE implements SimpleStock{
	
	private String symbol = SimpleStock.SYMBOL_ALE;
	
	// Would be initialised from a database probably
	private double lastDividend = 23;
	
	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public double calculateDividendYeild(double marketPrice) {
		
		double yeild = 0;
		try{
			yeild = (lastDividend / marketPrice);
		}catch(Exception e){
			// Need find out how to handle the exception 
			e.printStackTrace();
		}
		
		return yeild;
	}

	@Override
	public double calculatePERatio(double marketPrice) {
		
		double peRatio = 0;
		try{
			peRatio = (marketPrice / lastDividend);
		}catch(Exception e){
			// Need find out how to handle the exception 
			e.printStackTrace();
		}
		
		return peRatio;
	}

}
