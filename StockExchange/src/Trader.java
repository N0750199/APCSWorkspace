import java.util.LinkedList;
import java.util.Queue;


public class Trader 
{
	private String traderName;
	private String traderPassword;
	private Queue<String> mailbox;
	private Brokerage myBrokerage;
	private TraderWindow myTraderWindow;
	
	public Trader(String username, String password)
	{
		this.traderName = username;
		this.traderPassword = password;
		mailbox = new LinkedList<String>();
	}
	
	public String getName()
	{
		return traderName;
	}
	
	public void getQuote(String symbol)
	{
		myBrokerage.getQuote(symbol);
	}
	
	public void placeOrder(TradeOrder tradeorder)
	{
		myBrokerage.placeOrder(tradeorder);
	}
}
