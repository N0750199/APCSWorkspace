/**
 * 
 */

/**
 * @author jack
 *
 */
public class TradeOrder {

	/**
	 * @param args
	 */
	
	private String stockSymbol;
	private int numShares;
	private boolean buy;
	private boolean market;
	private double price;
	private Trader myTrader;
	
	
	public TradeOrder(Trader myTrader,String stockSymbol,  boolean buy,boolean market, int numShares,double price)
	{
		this.stockSymbol=stockSymbol;
		this.numShares=numShares;
		this.buy=buy;
		this.market=market;
		this.price=price;
		this.myTrader=myTrader;
	}
	
	public String getStockSymbol()
	{
		return stockSymbol;
	}
	
	public int getNumShares()
	{
		return numShares;
	}
	
	public boolean getBuy()
	{
		return buy;
	}
	
	public boolean getMarket()
	{
		return market;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	

}
