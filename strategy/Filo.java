package strategy;

import java.util.Comparator;

import hw3.MazeCell;

/**
 * MazeCells are sorted in a first-in-last-out (Filo) manner. 
 *
 */
public class Filo implements Comparator<MazeCell> {
	@Override
	public int compare(MazeCell c1, MazeCell c2) {
		return c2.getTimeStamp() - c1.getTimeStamp();
	}
}
