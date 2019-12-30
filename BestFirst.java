package strategy;

import java.util.Comparator;

import hw3.MazeCell;

/**
 * 
 * MazeCells are sorted in a best-first manner. 
 *
 */
public class BestFirst implements Comparator<MazeCell> {
	private MazeCell goal;
	public BestFirst(MazeCell goal) {
		this.goal = goal;
	}
	@Override
	public int compare(MazeCell c1, MazeCell c2) {
		
		int dist1 = c1.distance(goal);
		int dist2 = c2.distance(goal);

		return dist1 - dist2;
	}
}