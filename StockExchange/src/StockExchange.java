import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class StockExchange {

	/**
	 * @param args
	 */
	private Brokerage myBrokerage;
	private HashMap<String,Stock> stockList;
	
	public StockExchange() //Constructs a new stock exchange object
	{
		stockList=new HashMap<String,Stock>();
	}
	public String getQuote(String stockSymbol)//Returns a quote for a given stock.
	{
		return stockList.get(stockSymbol).getQuote();
	}
	public void listStock(String stockSymbol, String companyName, double price) //Adds a new stock with given parameters to the listed stocks.
	{
		Stock s=new Stock(stockSymbol,companyName,price);
		stockList.put(stockSymbol,s);
	}
	public void placeOrder(TradeOrder to) //Places a trade order by calling stock.placeOrder for the stock specified by the stock symbol in the trade order.
	{
		stockList.get(to.getSymbol()).placeOrder(to);
	}
	
}
