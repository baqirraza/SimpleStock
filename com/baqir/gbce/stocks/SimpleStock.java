package com.baqir.gbce.stocks;

public interface SimpleStock {
	
	public static String SYMBOL_TEA = "TEA"; 
	public static String SYMBOL_POP = "POP";
	public static String SYMBOL_ALE = "ALE";
	public static String SYMBOL_GIN = "GIN";
	public static String SYMBOL_JOE = "JOE";
	
	public String getSymbol();
	
	public double calculatePERatio(double marketPrice);
	
	public double calculateDividendYeild(double marketPrice);
	
}
