package strategy;

import java.util.Comparator;

import hw3.MazeCell;

/**
 * 
 * MazeCells are sorted according to the A* method. 
 *
 */
public class Astar implements Comparator<MazeCell> {
	private MazeCell goal;
	public Astar(MazeCell goal) {
		this.goal = goal;
	}
	@Override
	public int compare(MazeCell c1, MazeCell c2) {
		
		int a1 = c1.distance(goal);
		int a2 = c2.distance(goal);
		int dist1 = c1.getTimeStamp() + a1;
		int dist2 = c2.getTimeStamp() + a2;
		
		if(dist1 == dist2)
			return a1 - a2;
		else
			return dist1 - dist2;
	}
}