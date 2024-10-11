import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[][] forest;
    public static int[][] check;
    public static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int moves;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        forest = new int[n][n];
        check = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                forest[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int c = dfs(i,j);
                moves = Math.max(moves, c);
            }
        }
        
        System.out.println(moves);
    }
    
    public static int dfs(int r, int c) {
        if(check[r][c] != 0) {
            return check[r][c];
        }
        
        check[r][c] = 1;
        
        for(int i=0; i<4; i++) {
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < n && forest[nr][nc] > forest[r][c]) {
                check[r][c] = Math.max(check[r][c], dfs(nr,nc) + 1);
            }
        }
        return check[r][c];
    }
}