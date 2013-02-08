import java.util.PriorityQueue;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class Stock {

	/**
	 * @param args
	 */
	
	private String stockSymbol;
	private String companyName;
	private double lowSellPrice;
	private double highSellPrice;
	private double lastPrice;
	private double volume;
	private StockExchange myStockExchange;
	private PriorityQueue<TradeOrder> buyOrders;
	private PriorityQueue<TradeOrder> sellOrders;
	
	public Stock(String stockName, String companyName, double price)
	{
		this.stockSymbol=stockName;
		this.companyName=companyName;
		lowSellPrice=price;
		highSellPrice=price;
		lastPrice=price;
		volume=0;
		PriceComparator ascending=new PriceComparator();
		PriceComparator descending =new PriceComparator(false);
		buyOrders=new PriorityQueue<TradeOrder>(10,ascending);
		sellOrders=new PriorityQueue<TradeOrder>(10, descending);
	}
	
	public void placeOrder(TradeOrder order)
	{
		String msg="";
		msg+="New Order:  ";
		
		if(order.isBuy())
		{
			buyOrders.add(order);
			msg+="Buy ";
		}
		else
		{
			sellOrders.add(order);
			msg+="Sell ";
		}
		
		msg+=stockSymbol+" ("+companyName+")"+'\n'+order.getShares()+" shares at $"+order.getPrice();
		
		order.getTrader().recieveMessage(msg);
		
		execute();
	}
	
	public void execute()
	{
		
	}
	
	public double returnQuote()
	{
		return lowSellPrice;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}