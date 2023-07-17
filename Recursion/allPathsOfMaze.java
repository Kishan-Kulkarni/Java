package Recursion;

import java.util.ArrayList;

public class allPathsOfMaze {
    public static void main(String[] args) {

        boolean maze[][]={{true, true, true}, {true, true, true}, {true, true, true}};
        System.out.println(printAllPaths(maze, maze.length, maze[0].length, ""));
        System.out.println(printPaths(maze, 0, 0, ""));
        
    }
    private static ArrayList<String> printAllPaths(boolean[][] maze, int r, int c, String p) {

        if(maze[maze.length-r][maze[0].length-c]){
            maze[maze.length-r][maze[0].length-c]=false;
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

            ArrayList<String> down=printAllPaths(maze, r-1, c, p+'D');
            ArrayList<String> right=printAllPaths(maze, r, c-1, p+'R');
            ArrayList<String> up =new ArrayList<>();
            ArrayList<String> left =new ArrayList<>();

            if(maze.length-r>0){
                 up=printAllPaths(maze, r+1, c, p+'U');
            }

            if(maze[0].length-c>0){
                left=printAllPaths(maze, r, c+1, p+'L');
            }

        down.addAll(right);
        down.addAll(up);
        down.addAll(left);

        maze[maze.length-r][maze[0].length-c]=true;

        return down;
        }else{
            return new ArrayList<>();
        }
    }

    private static ArrayList<String> printPaths(boolean maze[][], int r, int c, String p){
        if(maze[r][c]){
            maze[r][c]=false;
            if(r==maze.length-1){
                for(int i=0; i<c-1; i++){
                    p+="R";
                }
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
                return list;
            }
    
            if(c==maze[0].length-1){
                for(int i=0; i<r-1; i++){
                    p+="D";
                }
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
                return list;
            }


            ArrayList<String> right=printPaths(maze, r, c+1, p+'R');
            ArrayList<String> down=printPaths(maze, r+1, c, p+'D');

            ArrayList<String> up=new ArrayList<>();
            ArrayList<String> left=new ArrayList<>();

            if(r>0){
                 up=printPaths(maze, r-1, c, p+'U');
            }

            if(c>0){
               left=printPaths(maze, r, c-1, p+'L');
            }

            down.addAll(up);
            left.addAll(right);
            down.addAll(left);
            maze[r][c]=true;
            return down;
        }else{
            return new ArrayList<>();
        }
    }
}
