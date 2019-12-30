package maze;

import hw3.MazeCell;

/**
 * Observer for status changes in a maze cell
 */
public interface MazeObserver
{
  /**
   * Notifies the observer that the cell status has changed.
   * @param cell
   */
  public void updateStatus(MazeCell cell);
}
