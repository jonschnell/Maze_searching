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

import java.awt.Point;

import java.util.ArrayList;

import maze.Status;

/**
 * Constructs a maze cell whose location is specified by the given row and
 * column, whose status is WALL by default, and whose parent is null.
 */
public class MazeCell {
	/**
	 * Constructs a maze cell whose location is specified by the given row and
	 * column, whose status is WALL by default, and whose parent is null. The cell
	 * initially has no neighbors. Its initial time stamp is 0.
	 * 
	 * @param r
	 * @param c
	 */
	public MazeCell(int r, int c) {
		status = Status.WALL;// sets status to wall
		parent = null;// sets parent to null
		neighbors = new ArrayList<>();// creates array list of neighbors
		p = new Point(r, c);// creates a point containing rows and columns
		time = 0;// sets time t0 o
	}

	/**
	 * the maze to which this MazeCell belongs.
	 */
	private Maze owner;
	/**
	 * Status of this cell.
	 */
	private Status status;
	/**
	 * the parent of the cell
	 */
	private MazeCell parent;
	/**
	 * point pair of ints
	 */
	private Point p;
	/**
	 * maze cell of neighbors
	 */
	private ArrayList<MazeCell> neighbors;
	/**
	 * time increments with path
	 */
	private int time;

	/**
	 * Update the status of this cell and notifies the owner that this current
	 * cell's status has changed
	 * 
	 * @param cell
	 */
	public void setStatus(Status s) {
		status = s;
		if (owner != null) {
			owner.updateStatus(this);
		}
	}

	/**
	 * return the status of the current the status
	 * 
	 * @return status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Adds an observer for changes in this cell's status.
	 * 
	 * @param obs
	 */
	public void setOwner(Maze maze) {
		owner = maze;
	}

	/**
	 * returns point p
	 * 
	 * @return p
	 */
	public Point getLocation() {
		return p;
	}

	/**
	 * adds a neighbor to the cell
	 * 
	 * @param m
	 */
	public void addNeighbor(MazeCell m) {

		neighbors.add(m);

	}

	/**
	 * Returns the neighbors of the current cell. If a cell has no neighbor, the
	 * method must still return an ArrayList, which is empty.
	 * 
	 * @return neighbors
	 */
	public ArrayList<MazeCell> getNeighbors() {

		return neighbors;
	}

	/**
	 * Returns a string representation of this cell's row and column numbers
	 * enclosed by a pair of parenthesis, e.g., (3, 4), or (10, 0).
	 * 
	 */
	@Override
	public String toString() {

		return "(" + p.x + "," + p.y + ")";
	}

	/**
	 * Gets the parent of this cell. This method returns null if the current cell
	 * has no parent.
	 * 
	 * @return
	 */
	public MazeCell getParent() {
		if (parent == null) {
			return null;
		}

		return parent;
	}

	/**
	 * Sets the parent of this cell with the given parent.
	 * 
	 * @param parent
	 */
	public void setParent(MazeCell parent) {

		this.parent = parent;

	}

	/**
	 * Returns the time stamp of this cell
	 * 
	 * @return time
	 */
	public int getTimeStamp() {

		return time;
	}

	/**
	 * Sets the time stamp of this cell
	 * 
	 * @param time
	 */
	public void setTimeStamp(int time) {

		this.time = time;

	}

	/**
	 * Computes the Manhattan distance between this cell and other cell. The
	 * distance between two points measured along axes at right angles. In a plane
	 * with p1 at (x1, y1) and p2 at (x2, y2), it is |x1 - x2| + |y1 - y2|.
	 * 
	 * @param other
	 * @return |x1 - x2| + |y1 - y2|
	 */
	public int distance(MazeCell other) {

		return Math.abs(p.x - other.p.x) + Math.abs(p.y - other.p.y);
	}

}
