import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int[][] graph;
    // public static int[][] b_graph;
    public static Queue<Integer> q = new LinkedList<>();
    public static boolean[] d_visited;
    public static boolean[] b_visited;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // # of nodes
        m = sc.nextInt();  // # of edges
        int v = sc.nextInt();  // starting vertex

        graph = new int[n+1][n+1];
        d_visited = new boolean[n+1];
        b_visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        dfs(v);
        System.out.println();
        bfs(v);
        System.out.println();
    }

    public static void dfs(int v) {
        d_visited[v] = true;
        System.out.print(v + " ");

        for(int i=1; i<=n; i++) {
            if(!d_visited[i] && graph[v][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        q.offer(v);
        b_visited[v] = true;

        while(!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");
            for(int i=1; i<=n; i++) {
                if(!b_visited[i] && graph[v][i] == 1) {
                    q.offer(i);
                    b_visited[i] = true;
                }
            }

        }
    }
}