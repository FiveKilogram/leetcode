package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 *
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，
 * 只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 *
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 */
public class Main2 {
    public static void main(String[] args) {
        Main2 main = new Main2();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int mg[][] = new int[a][b];
        boolean visited[][] = new boolean[a][b];

        while (scanner.hasNext()){
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    mg[i][j] = scanner.nextInt();
                    visited[i][j] = false;
                }
            }
        }

        List<path> list = new LinkedList<>();

        main.dfs(mg,list,0,0,visited);

        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public boolean dfs(int mg[][], List<path> list, int x, int y, boolean[][] visited){

        list.add(new path(x, y));
        visited[x][y] = true;

        if (x == mg.length - 1 && y == mg[0].length - 1) {
            return true;
        }

        if((x+1 < mg.length)&&(mg[x+1][y]==0)&&(!visited[x+1][y])){
            visited[x+1][y] = true;
            if(dfs(mg,list,x+1,y,visited)){
                return true;
            };
        }
        if((x-1 >=0 )&&(mg[x-1][y]==0)&&(!visited[x-1][y])){
            visited[x-1][y] = true;
            if(dfs(mg,list,x-1,y,visited)){
                return true;
            }
        }
        if((y+1 < mg[0].length)&&(mg[x][y+1]==0)&&(!visited[x][y+1])){
            visited[x][y+1] = true;
            if(dfs(mg,list,x,y+1,visited)){
                return true;
            }

        }
        if((y-1 >= 0)&&(mg[x][y-1]==0)&&(!visited[x][y-1])){
            visited[x][y-1] = true;
            if(dfs(mg,list,x,y-1,visited)){
                return true;
            };
        }
        list.remove(list.size()-1);
        visited[x][y] = false;
        return false;
    }

    static class path{
        int x;
        int y;
        public path(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" +
                    + x +
                    "," + y +
                    ')';
        }
    }
}