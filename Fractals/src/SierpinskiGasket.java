/**
 * 
 */

/**
 * @author jack
 *
 */

import edu.gatech.mediaprogramming.*;

public class SierpinskiGasket extends Turtle{

	/**
	 * @param args
	 */
	
	public void drawGasket(int depth, double length)
	{
		if(depth==1)
		{
			int angle=30;
			turn(angle);
			forward(length);
			
			turn(angle*4);
			forward(length);
			
			turn(angle*4);
			forward(length);
			
			turn(angle*4);
			
			try{Thread.sleep(0);}
			catch(InterruptedException e){}
		}
		else
		{
			int angle=30;
			turn(angle);
			forward(length/2);
			turn(3*angle);
			drawGasket(depth-1, length/2);
			turn(-5*angle);
			drawGasket(depth-1,length/2);
			turn(4*angle);
			forward(length/2);
			turn(-5*angle);
			drawGasket(depth-1,length/2);
			turn(-4*angle);
			forward(length/2);
			turn(4*angle);
			
		}
	}
	
	
	
	
	
	public void drawKochCurve(int depth, double length)
	{
		if(depth==1)
		{
			forward(length);
			try
			{
				Thread.sleep(0);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		else
		{
			drawKochCurve(depth-1,length/3);
			turn(-60);
			drawKochCurve(depth-1,length/3);
			turn(120);
			drawKochCurve(depth-1,length/3);
			turn(-60);
			drawKochCurve(depth-1,length/3);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SierpinskiGasket sg=new SierpinskiGasket();
		sg.drawGasket(5,250);
		sg.hide();
		

	}

}
