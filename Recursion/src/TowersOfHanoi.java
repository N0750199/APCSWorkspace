/**
 * 
 */

/**
 * @author jack
 *
 */
public class TowersOfHanoi {

	public static int numMoves=0;
	/**
	 * @param args
	 */
	public static void moveDisk(int start, int goal)
	{
		System.out.println("Move the top disk from peg " +start+" to peg "+goal);
		numMoves++;
	}
	
	public static void hanoi(int nDisks, int start, int store, int goal)
	{
		if(nDisks>=1)	//base case is nDisks==1
		{
			hanoi(nDisks-1,start,goal,store);
			moveDisk(start,goal);
			hanoi(nDisks-1,store,start,goal);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		hanoi(4,1,2,3);
		System.out.println("Moves: "+numMoves);
	}

}
