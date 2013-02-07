import java.util.Comparator;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class PriceComparator implements Comparator<TradeOrder>{

	/**
	 * @param args
	 */
	
	
	public int compare(TradeOrder t1,TradeOrder t2)
	{
		double difference=t1.getPrice()-t2.getPrice();
		if(difference>0)
			return 1;
		if(difference<0)
			return -1;
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	

}