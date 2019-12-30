/**
 * 
 * @author Jonathon Schnell
 * @version 1.0
 * @since 11-5-2019
 * COM S 227
 * homework3
 *
 */

package hw3;

import maze.MazeObserver;
import maze.Status;

/**
 * Constructs a maze based on a 2D grid.
 *
 */
public class Maze {

	/**
	 * Observer to be notified in case of changes to cells in this maze.
	 */
	private MazeObserver observer;

	/*
	 * a stores parsed maze data in characters
	 */
	private char a[][];

	/**
	 * b stores mazecells and therefore each cell's attributes
	 */
	private MazeCell b[][];

	/**
	 * stores row of the start cell
	 */
	private int startI;

	/**
	 * stores column of the start cell
	 */
	private int startJ;

	/**
	 * stores row of the goal cell
	 */
	private int goalI;

	/**
	 * stores column of the goal cell
	 */
	private int goalJ;

	/**
	 * Constructs a maze based on a 2D grid. The given strings, rows, represent rows
	 * of a maze, where '#' represents a wall, a blank represents a possible path,
	 * 'S' represents the starting cell, and '$' represents the goal cell. The maze
	 * must be rectangular, which means the Strings in the given rows must have the
	 * same length. Also, there must be only one start cell and one goal cell in the
	 * maze. For each MazeCell in the maze, set its owner to be the current maze,
	 * its status as GOAL if it is the goal cell, UNVISITED if it is not the goal
	 * nor the wall. For each MazeCell that is accessible (not a wall), its
	 * accessible neighbors MUST be added in the order of top, left, bottom, right.
	 * Cells on the boundary of the maze or near a wall will have fewer accessible
	 * neighbors.
	 * 
	 * @param rows
	 */
	public Maze(String[] rows) {

		// creates a of proper size
		a = new char[rows.length][rows[0].length()];
		// created b of proper size
		b = new MazeCell[rows.length][rows[0].length()];

		// parses string array row into a multidimensional character array a
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[0].length(); j++) {
				a[i][j] = rows[i].charAt(j);
			}
		}

		// parses char array a
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[0].length(); j++) {
				// creates a mazecell cell for each dimension of the maze
				MazeCell cell = new MazeCell(i, j);
				// looks for walls
				if (rows[i].charAt(j) == '#') {
					// sets status
					cell.setStatus(Status.WALL);
					// sets owner
					cell.setOwner(this);
				}
				// looks for black space
				if (rows[i].charAt(j) == ' ') {
					cell.setStatus(Status.UNVISITED);
					cell.setOwner(this);

				}
				// looks for starting point
				if (rows[i].charAt(j) == 'S') {
					cell.setStatus(Status.UNVISITED);
					cell.setOwner(this);
					// saves start row
					startI = i;
					// saves start column
					startJ = j;

				}
				// looks for the goal
				if (rows[i].charAt(j) == '$') {
					cell.setStatus(Status.GOAL);
					cell.setOwner(this);
					// saves the goal row
					goalI = i;
					// saves the goal column
					goalJ = j;

				}
				// after constructing the cell with proper attributes it is saved at proper
				// index
				b[i][j] = cell;
			}
		}

		// parses mazecell array b to set neighbors
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[0].length(); j++) {
				// the first neighbor is above the cell i>0 ensures that index does not go out
				// of range
				// the first neighbor can only be set if there in a cell above the current cell
				if (i > 0) {
					// if the current cell first neighbor(cell above) is not a wall we will add it
					// to neighbor list
					if (b[i - 1][j].getStatus() != Status.WALL) {
						b[i][j].addNeighbor(b[i - 1][j]);
					}
				}
				// second neighbor is to the left j>0 ensures that index does not go out of
				// range
				// the second neighbor will only be set if there is a cell to the left
				if (j > 0) {
					// if the current cell second neighbor(cell left) is not a wall we will add it
					// to neighbor list
					if (b[i][j - 1].getStatus() != Status.WALL) {
						b[i][j].addNeighbor(b[i][j - 1]);
					}
				}
				// third neighbor is below current cell ensures that index does not go out of
				// range
				// third neighbor will only be set if there is a cell below current
				if (i < rows.length - 1) {
					// if the current cell third neighbor(cell below) is not a wall we will add it
					// to neighbor list
					if (b[i + 1][j].getStatus() != Status.WALL) {
						b[i][j].addNeighbor(b[i + 1][j]);
					}
				}
				// fourth neighbor is to the right of current ensures that index does not go out
				// of range
				// fourth neighbor will only be set if there is a cell to the right of current
				if (j < rows[0].length() - 1) {
					// if the current cell fourth neighbor(cell right) is not a wall we will add it
					// to neighbor list
					if (b[i][j + 1].getStatus() != Status.WALL) {
						b[i][j].addNeighbor(b[i][j + 1]);
					}
				}

			}
		}
	}

	/**
	 * Notifies the observer that the given cell's status has changed.
	 * 
	 * @param cell
	 */
	public void updateStatus(MazeCell cell) {
		if (observer != null) {
			observer.updateStatus(cell);
		}
	}

	/**
	 * Returns the cell at the given position.
	 * 
	 * @param row
	 * @param col
	 * @return b[row][col]
	 */
	public MazeCell getCell(int row, int col) {

		return b[row][col];
	}

	/**
	 * Returns the number of rows in this maze.
	 * 
	 * @return a.length (number of rows)
	 */
	public int getRows() {

		return a.length;
	}

	/**
	 * Returns the number of columns in this maze.
	 * 
	 * @return a[0].length (number of col)
	 */
	public int getColumns() {

		return a[0].length;
	}

	/**
	 * Returns the start cell for this maze.
	 * 
	 * @return b[startI][startJ]
	 */
	public MazeCell getStart() {

		return b[startI][startJ];
	}

	/**
	 * Returns the goal cell for this maze.
	 * 
	 * @return b[goalI][goalJ]
	 */
	public MazeCell getGoal() {

		return b[goalI][goalJ];
	}

	/**
	 * Sets the observer for the cells of this maze.
	 * 
	 * @param obs
	 */
	public void setObserver(MazeObserver obs) {
		observer = obs;
	}

}
