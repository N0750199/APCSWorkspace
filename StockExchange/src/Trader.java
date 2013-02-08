import java.util.LinkedList;
import java.util.Queue;


public class Trader implements Comparable<Trader>
{
	private String traderName;
	private String traderPassword;
	private Queue<String> mailbox;
	private Brokerage myBrokerage;
	private TraderWindow myTraderWindow;
	
	public Trader(Brokerage myBrokerage,String username, String password)
	{
		this.myBrokerage=myBrokerage;
		this.traderName = username;
		this.traderPassword = password;
		mailbox = new LinkedList<String>();
		myBrokerage.login();
	}
	
	//returns screen name
	public String getName()
	{
		return traderName;
	}
	
	//Requests quote from brokerage
	public void getQuote(String symbol)
	{
		myBrokerage.getQuote(symbol);
	}
	
	//true if mailbox isn't empty
	public boolean hasMessages()
	{
		return mailbox.size()!=0;
	}
	
	//opens new window and prints out messages and deletes them
	public void openWindow()
	{
		myTraderWindow=new TraderWindow(this);
		while(mailbox.size()!=0)
		{
			myTraderWindow.showMessage(mailbox.remove());
		}
	}
	
	//adds a message to mailbox and displays all messages if logged in
	public void recieveMessage(String msg)
	{
		mailbox.add(msg);
		if(myTraderWindow!=null)
		{
			while(mailbox.size()!=0)
			{
				myTraderWindow.showMessage(mailbox.remove());
			}
		}
	}
	
	//returns password
	public String getPassword()
	{
		return traderPassword;
	}
	
	//places order by calling brokerage's placeOrder
	public void placeOrder(TradeOrder tradeorder)
	{
		myBrokerage.placeOrder(tradeorder);
	}

	public void quit()
	{
		myBrokerage.logout();
		myTraderWindow=null;
	}
	
	
	//equal if screen names are the same
	public boolean equals(Object other)
	{
		if(other instanceof Trader)
		{
			if(((Trader)other).traderName.equals(traderName))
				return true;
		}
		return false;
	}
	
	
	//compares based on screen name
	public int compareTo(Trader trader2) 
	{
		return traderName.compareTo(trader2.traderName);
	}
}