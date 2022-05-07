import java.util.Scanner;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
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
        list.add(new path(0,0));

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

    }

    public boolean dfs(int mg[][], List<path> list, int x, int y, boolean[][] visited){

        if(x==mg.length-1&&y==mg[0].length-1){
            return true;
        }

        if((x+1 < mg.length)&&(mg[x+1][y]==0)&&(!visited[x+1][y])){
            visited[x+1][y] = true;
            if(dfs(mg,list,x+1,y,visited)){
                list.add(new path(x+1,y));
                return true;
            };
        }
        if((x-1 >=0 )&&(mg[x-1][y]==0)&&(!visited[x-1][y])){
            visited[x-1][y] = true;
            if(dfs(mg,list,x-1,y,visited)){
                list.add(new path(x-1,y));
                return true;
            }
        }
        if((y+1 < mg[0].length)&&(mg[x][y+1]==0)&&(!visited[x][y+1])){
            visited[x][y+1] = true;
            if(dfs(mg,list,x,y+1,visited)){
                list.add(new path(x,y+1));
                return true;
            }

        }
        if((y-1 >= 0)&&(mg[x][y-1]==0)&&(!visited[x][y-1])){
            visited[x][y-1] = true;
            if(dfs(mg,list,x,y-1,visited)){
                list.add(new path(x,y-1));
                return true;
            };
        }
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
