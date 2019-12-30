package ui;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import maze.MazePanel;
import maze.Status;
import hw3.Maze;
import hw3.MazeCell;
import strategy.Astar;
import strategy.BestFirst;
import strategy.Fifo;
import strategy.Filo;

public class RunSearcher
{
  public static final String[] MAZE1 = {
    "#######",
    "#  #$ #",
    "# ### #",
    "#   # #",
    "# ### #",
    "#     #",
    "#S#####",
};

  public static final String[] MAZE2 = {
    "#########",
    "#  #  # #",
    "# ###$# #",
    "#   # # #",
    "# ###   #",
    "#     ###",
    "#S#######",
};
  
  public static final String[] MAZE3 = {
    "#######",
    "#  #  #",
    "# ### #",
    "#   # #",
    "# ### #",
    "#     #",
    "#S#####",
};
  
  public static final String[] MAZE4 = {
    "#######",
    "# $   #",
    "# # # #",
    "#     #",
    "# ### #",
    "#     #",
    "#S#####",
};

  // maze posted by Anthoni Weise on Piazza, slightly modified 
  // so the solution is unique
  public static final String[] MAZE5= {
  "#############################",
  "#                           S",
  "### #### # ## # ### # # ## ##",
  "# #    # #    #     ##  ##  #",
  "# ###### ###########   #   ##",
  "#        #           ### ## #",
  "########### # #### # # #    #",
  "#           #    # #   # ####",
  "# # # # ### # ## # ##### #  #",
  "#   ### # # #    #    ## #  #",
  "## #  # # # ######### ## ## #",
  "#  ## # # #       # # ##    #",
  "##    # #   ### # # # ##    #",
  "#  ###### # # # # #   #### ##",
  "# #   #       # # ###### ####",
  "# # #### #### ###      #   ##",
  "#   #  # #      ###### # #  #",
  "#   # ## ######    # #    # #",
  "#   #  #       ###   # #### #",
  "#   # ########## ##### #    #",
  "### #                  ######",
  "# ###### # ###########      #",
  "#        #        # ####### #",
  "# ################# #     # #",
  "#                 # ### ### #",
  "# # # ######### #     #     #",
  "## # #   #   # ## ## ########",
  "#      #   #      #         #",
  "#$###########################",
};
  
  public static final String[] MAZE6= {
		  "#############################",
		  "#             S             #",
		  "### #### # ## # ### # # ## ##",
		  "#$#    # #    #     ##  ##  #",
		  "# ###### #### # ####   #   ##",
		  "#        #           ### ## #",
		  "########### # ## # # # #    #",
		  "#                # #   # ####",
		  "# # # # ### # ## # ##### #  #",
		  "#   ### # #      #    ## #  #",
		  "## #  # # # #### #### ## ## #",
		  "#  ## # # #       # # ##    #",
		  "##    # #   ### # # # ##    #",
		  "#  ###### # # # # #   #### ##",
		  "# #   #       # # ###### ####",
		  "# # #### #### ###      #   ##",
		  "#   #  # #      ###### # #  #",
		  "#   # ## ######    # #    # #",
		  "#   #  #       ###   # #### #",
		  "#   # ########## ##### #    #",
		  "### #                  ######",
		  "# ###### # ###########      #",
		  "#        #        # ####### #",
		  "# ################# #     # #",
		  "#                 # ### ### #",
		  "# # # ######### #     #     #",
		  "## # #   #   # ## ## ########",
		  "#      #   #      #         #",
		  "#############################",
		};
  
  public static final String[] MAZE7= {
		  "#############################",
		  "#             S             #",
		  "### #### # ## # ### # # ## ##",
		  "# #    # #    #     ##  ##  #",
		  "# ###### #### # ####   #   ##",
		  "#        #           ### ## #",
		  "########### # ## # # # #    #",
		  "#                # #   # ####",
		  "# # # # ### # ## # ##### #  #",
		  "#   ### # #      #    ## #  #",
		  "## #  # # # #### #### ## ## #",
		  "#  ## # # #       # # ##    #",
		  "##    # #   ### # # # ##    #",
		  "#  ###### # # # # #   #### ##",
		  "# #   #       # # ###### ####",
		  "# # #### #### ###      #   ##",
		  "#   #  # #      ###### # #  #",
		  "#   # ## ######    # #    # #",
		  "#   #  #       ###   # #### #",
		  "#   # ########## ##### #    #",
		  "### #                  ######",
		  "# ###### # ###########      #",
		  "#        #        # ####### #",
		  "# ################# #     # #",
		  "#                 # ### ### #",
		  "# # # ######### #     #     #",
		  "## # #   #   # ## ## ########",
		  "$      #   #      #         #",
		  "#############################",
		};
  
  public static final String[] MAZE8= {
		  "#############################",
		  "#             S             #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#     $                     #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#############################",
		};

  public static final String[] MAZE9= {
		  "#############################",
		  "#             S             #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#     #                #    #",
		  "#     #                #    #",
		  "#     #              ##     #",
		  "#      #            #       #",
		  "#       #          #        #",
		  "#       #      ####         #",
		  "#       #######             #",
		  "#                           #",
		  "##                          #",
		  "# #                         #",
		  "#  #                        #",
		  "#   #                       #",
		  "#    #                      #",
		  "#     #                     #",
		  "#      #                    #",
		  "#       #                   #",
		  "#        #                  #",
		  "#        $#                 #",
		  "#          #                #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#############################",
		};
  
  public static final String[] MAZE10= {
		  "#############################",
		  "#                           #",
		  "#                           #",
		  "#     ##################    #",
		  "#     #                     #",
		  "#     #                     #",
		  "#     #                     #",
		  "#     #                  S  #",
		  "#     #                     #",
		  "#     #                     #",
		  "#     #                     #",
		  "#     ##################    #",
		  "#    $                      #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#                           #",
		  "#############################",
		};
  
public static void main(String[] args)
{
  // Create the maze from the string description. Select one from above, 
  // or create a fun one on your own!
  Maze maze = new Maze(MAZE7);   
  
  // Start the UI, using a 400 millisecond delay between frames
  MazePanel.start(maze, 10);
  
  // Create empty array list to store the path
  ArrayList<MazeCell> path = new ArrayList<MazeCell>();
  
  // Search beginning at the designated start cell
  Scanner in = new Scanner(System.in);
  System.out.println("Enter your choice serach method: ");
  System.out.println("\t 1. Depth first search");
  System.out.println("\t 2. Breadth first search");
  System.out.println("\t 3. A* search");
  System.out.println("\t 4. Best first search");
  System.out.print("Your choice: ");
  int choice = in.nextInt();
  boolean success;
  if(choice==2)
     success = forwardSearch(maze.getStart(), path, new Fifo());
  else if(choice==3)
	 success = forwardSearch(maze.getStart(), path, new Astar(maze.getGoal()));
  else if(choice==4)
	 success = forwardSearch(maze.getStart(), path, new BestFirst(maze.getGoal()));
  else // choice 1
	 success = forwardSearch(maze.getStart(), path, new Filo());
	  
  
  // Optionally, print the path to check it
  if(success)
	  System.out.println(path);
}

/**
 * Find a path from the current cell to the goal using the forward search
 * algorithm outlined in Figure 2.4 in Steve LaValle's Planning Algorithms book.
 * Returns true if the current
 * cell is the goal or if the goal is found in a search initiated from this cell
 * by searching a neighbor. Returns false if the goal is not found. If the goal
 * is found, then when this method returns, the given ArrayList will contain a
 * path from the current cell to the goal. This can be done by back tracing from the goal if 
 * a parent cell is maintained for each cell right before it is added to the priority queue. 
 * 
 * @param start
 *            the current cell at which a search is being initiated
 * @param solution
 *            an empty array list
 * @param comparator
 * 			  which specifies how search is to be made           
 * @return true if the goal was found through this search, false otherwise
 */
 public static boolean forwardSearch(MazeCell start, ArrayList<MazeCell> solution, Comparator<MazeCell> comparator) {
	
	// set up a priority queue. 
	ArrayList<MazeCell> q = new ArrayList<>();
	q.add(start);
	start.setTimeStamp(0);
	start.setParent(null);
	start.setStatus(Status.VISITED);
	
	MazeCell c = null;
	boolean solutionFound = false;
	while(!q.isEmpty() && !solutionFound) {
		
		c = q.remove(0);
		for(MazeCell n : c.getNeighbors()) {
			
			switch(n.getStatus()) {
			case VISITED:
			case DEAD:
				break;
			case GOAL:
				solutionFound = true;
				break;
			default:
				n.setParent(c);
				n.setStatus(Status.VISITED);
				n.setTimeStamp(c.getTimeStamp() + 1);
				q.add(n);
				q.sort(comparator);
			}
		}
		c.setStatus(Status.DEAD);
	}
	
	if(solutionFound) {
		while(c != null) {
			solution.add(c);
			c.setStatus(Status.SUCCEEDED);
			c = c.getParent();
		}
	}
	
	System.out.println("Path length: " + solution.size());
	
	return solutionFound;
 }

}