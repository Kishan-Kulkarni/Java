package Recursion;

import java.util.ArrayList;

public class printAllPathsObstacle {
    public static void main(String[] args) {
        boolean maze[][]={{true, true, true}, {true, true, true}, {false, true, true}};
        System.out.println(printNewPaths(maze, maze.length, maze[0].length, ""));
    }

    private static ArrayList<String> printNewPaths(boolean[][] maze, int r, int c, String p) {

        if(maze[maze.length-r][maze[0].length-c]){
            if(r==1){
                for(int i=0; i<c-1; i++){
                    p+="R";
                }
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
                return list;
            }
    
            if(c==1){
                for(int i=0; i<r-1; i++){
                    p+="D";
                }
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
                return list;
            }

            ArrayList<String> down=printNewPaths(maze, r-1, c, p+'D');
            ArrayList<String> right=printNewPaths(maze, r, c-1, p+'R');

        down.addAll(right);

        return down;
        }else{
            return new ArrayList<>();
        }
    }
}
