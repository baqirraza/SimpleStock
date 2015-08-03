package com.baqir.gbce.stocks;

public class SimpleStockGIN implements SimpleStock{
	
	private String symbol = SimpleStock.SYMBOL_GIN;
	
	// Would be initialised from a database probably
	private double fixedDividend = 2;
	private double parValue = 100;
	private double lastDividend = 8;
	
	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public double calculateDividendYeild(double marketPrice) {
		
		double yeild = 0;
		try{
			yeild = ((fixedDividend * parValue) / marketPrice);
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
