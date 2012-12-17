/**
 * 
 */
package projects.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

/**
 * @author jack
 *
 */
public class Bee extends Critter{

	/**
	 * @param args
	 */
	
	public void processActors(ArrayList<Actor> actors)
	{
		for(int i=0;i<actors.size();i++)
		{
			if(actors.get(i) instanceof Clover)
				(Clover)actors.get(i).pollinate();
		}
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs)
	{
		
		for(int i=0;i<locs.size();i++)
		{
			
		}
		return null;
	}
	
	public void makeMove(Location loc)
	{
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}