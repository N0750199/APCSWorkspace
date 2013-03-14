// 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;


/**
 *  In this program Cookie Monster finds the optimal path from 
 *  the upper left corner (0,0) to the lower right corner
 *  (SIZE-1,SIZE-1) in a cookie array.  The elements of
 *  the array contain cookies (a non-negative number) or barrels
 *  (-1).  On each step Cookie Monster can only go down or
 *  to the right.  He is not allowed to step on barrels. 
 *  The optimal path contains the largest number of cookies.
 *   
 *  The program prompts the user for a file name,
 *  reads the cookie array from the file, and reports the
 *  number of cookies on the optimal path. Assumed size of the
 *  grid of values i 12 x 12, stored in row-major order.
 *  
 *  Bonus:  Adapt the program to read 2 ints from the file first
 *  representing numRows and numCols, and then read all values into
 *  a 2-d array.  (Consult FloodFill project for an example.)
 *  
 *  The program also reports the actual optimal path, location
 *  by location.
 *  
 *  Finally, the program will output every successful path found,
 *  along with the total cookies along that path.
 */


public class CookieMonsterStarter
{
  private final int SIZE = 12; //Can be altered for different files. 
  private int[][] cookies = new int[SIZE][SIZE];
  
  
  public class Location
  {
	  private int row;
	  private int col;
	  
	  public Location(int row,int col)
	  {
		  this.row=row;
		  this.col=col;
	  }
	  
	  public int getRow()
	  {
		  return row;
	  }
	  
	  public int getCol()
	  {
		  return col;
	  }
	  
	  public String toString()
	  {
		  return "("+row+ " ,"+col+")";
	  }
  }
  
  public class Path
  {
	  private Queue<Location> locations=new LinkedList<Location>();
	  private int pathTotal;
	  
	  public int getPathTotal()
	  {
		  return pathTotal;
	  }
	  
	  public void addPoint(Location l)
	  {
		  locations.add(l);
		  pathTotal+=cookies[l.getRow(),l.getCol()];
	  }
  }
    
  /**
   *  Reads cookies from file
   */
  private void loadCookies(Scanner input)
  {  
    for (int row = 0;   row < SIZE;   row++)  
      for (int col = 0;   col < SIZE;   col++)  
        cookies[row][col] = input.nextInt();  
  }  

  /**
   *  Returns true if (row, col) is within the array and that position is
   *  not a barrel (-1); false otherwise
   */
  private boolean goodPoint(int row, int col)  
  {  
	  return row<cookies.length&&col<cookies[row].length&&cookies[row][col]!=-1;  
  }

  /**
   *  Returns the largest number of cookies collected by Monster
   *  on a path from (0,0) to (SIZE-1, SIZE-1)
   */
  
  private int optimalPath()  
  {  
	  // LOTS OF STUFF FOR HERE! Plan first!
	  Stack paths=new Stack();
	  
	  
	  
  }
  
  
  
  /**  The following is something we coded together in Ch20 work:
  *		E  is an Element Type
  * 	It is a Static method:  to activate it...
  *      in another class:  someotherq= CoookieMonster.copy(someq);
  *      in this class:   		 newq = copy(q);
  *      */
  public static <E>  Queue<E>   copy(Queue<E> q){
	  
	  Queue<E> q2 = new LinkedList<E>();
	  
	  if (!q.isEmpty()){
		  
		   E obj = q.remove();
		   E first = obj;
		   q2.add(obj);
		   q.add(obj);
		   
		   while (q.peek() != first) {
			   obj = q.remove();
			   q.add(obj);
			   q2.add(obj);
		   }  
	  }
	  
	  return q2;
  }
  
  

  public static void main(String args[])
  {  // Adapt this as you see fit.
    String fileName;

    if (args.length >= 1)
    {
      fileName = args[0];
    }
    else
    {
      Scanner kboard = new Scanner(System.in);
      System.out.print("Enter the cookies file name: ");
      fileName = kboard.nextLine();
     }

    File file = new File(fileName);
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Cannot open " + fileName);
      System.exit(1);
    }

    CookieMonsterStarter monster = new CookieMonsterStarter();
    monster.loadCookies(input);
    System.out.println("Optimal path has " +
                                  monster.optimalPath() + " cookies.\n");
  }
}