/* 
 * Oscar Hedblad
 * PID: o3415424
 * COP 3503 - Maze.java
 * 
 * DESCRIPTION: Program that finds the shortest path in a randomly
 * generated maze, starting at 's' and ending at 'e'. The randomly
 * generated maze will be passed as a 2D array, just as in the previous
 * week's assignment (Maze Creation). The way this program will display
 * the route it takes in order to find a path from 's' to 'e' is by marking
 * the accepted path with periods '.'.
 * As just mentioned, the found path must be marked with periods, but it may
 * NOT overwrite the 'e', 's', or '#' characters. Allowed moves are left, right,
 * up, and down. And of course, a path CANNOT break through any of the walls.
 * */


public class Maze {
// Method that solves the character maze, maze by row & column
 public static void solve(char [][] maze){
  recSolution(1,1,maze);
 }
 
/* Recursive solution. Takes in (1,1) as i & j initially, then finds
 * height and width of maze using the maze.length. Every recursive run
 * throgh this method will iterate one spot closer to the end ('e').
 * If it hits a dead end, without finding 'e', it will backtrack until
 * an alternate path, this will be done until the shoters path is found.  */
 public static boolean recSolution(int i, int j, char [][] maze) throws IndexOutOfBoundsException{
  
  /* If ONE move away from end ('e'). Return true. */
  if(maze[i][j+1] == 'e')
   return true;
  if(maze[i+1][j] == 'e')
   return true;
  /* RIGHT. If possible to move RIGHT, mark with period. */
  if(maze[i][j+1] == ' '){
   maze[i][j+1] = '.';
   /* Recursive call. If true, then we went down correct path. 
    * If not, then mark with white space. */
   if(recSolution(i, j+1, maze))
    return true;
   else{
    maze[i][j+1] = ' ';
   }
  }
  /* DOWN. If possible to move DOWN, mark with period. */
  if(maze[i+1][j] == ' '){
   maze[i+1][j] = '.';
   /* Recursive call. If true, then we went down correct path. 
    * If not, then mark with white space. */
   if(recSolution(i+1, j, maze))
    return true;
   else{
    maze[i+1][j] = ' ';
   }
  }
  /* UP. If possible to move UP, mark with period. */
  if(maze[i-1][j] == ' '){
   maze[i-1][j] = '.';
   /* Recursive call. If true, then we went down correct path. 
    * If not, then mark with white space. */
   if(recSolution(i-1, j, maze))
    return true;
   else{
    maze[i-1][j] = ' ';
   }
  }
  /* LEFT. If possible to move LEFT, mark with period. */
  if(maze[i][j-1] == ' '){
   maze[i][j-1] = '.';
   /* Recursive call. If true, then we went down correct path. 
    * If not, then mark with white space. */
   if(recSolution(i, j-1, maze))
    return true;
   else{
    maze[i][j-1] = ' ';
   }
  }  
  return false;
 }
}