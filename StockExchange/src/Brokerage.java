import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class Brokerage {

	/**
	 * @param args
	 */
	private TreeMap<Trader,String> myTraders;
	private TreeSet<Trader> loggedInTraders;
	private StockExchange myStockExchange;
	
	
	public double getQuote(String stockSymbol)
	{
		return myStockExchange.getQuote(stockSymbol);
	}
	
	public void placeOrder(TradeOrder to)
	{
		myStockExchange.placeOrder(to);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
