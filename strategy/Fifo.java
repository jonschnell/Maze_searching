package strategy;

import java.util.Comparator;

import hw3.MazeCell;

/**
 * 
 * MazeCells are sorted in a first-in-first-out (Fifo) manner.  
 *
 */
public class Fifo implements Comparator<MazeCell> {
	@Override
	public int compare(MazeCell c1, MazeCell c2) {
		return c1.getTimeStamp() - c2.getTimeStamp();
	}
}