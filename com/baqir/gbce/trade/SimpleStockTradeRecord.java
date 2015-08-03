package com.baqir.gbce.trade;

import java.util.Date;

import com.baqir.gbce.stocks.SimpleStock;

public class SimpleStockTradeRecord {
	
	public enum  BuySellIndecator  {BUY, SELL};
	
	private int quantity;
	private Date timeStamp;
	private double tradePrice;
	private BuySellIndecator buySellIndecator;
	private SimpleStock stock;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}

	public BuySellIndecator getBuySellIndecator() {
		return buySellIndecator;
	}

	public void setBuySellIndecator(BuySellIndecator buySellIndecator) {
		this.buySellIndecator = buySellIndecator;
	}

	public SimpleStock getStock() {
		return stock;
	}

	public void setStock(SimpleStock stock) {
		this.stock = stock;
	}
	
}
