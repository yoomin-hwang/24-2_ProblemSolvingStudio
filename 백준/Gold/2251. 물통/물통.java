import java.util.*;

public class Main {
    public static int maxa, maxb, maxc;
    public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxa = sc.nextInt();
        maxb = sc.nextInt();
        maxc = sc.nextInt();
        
        Pour();
        
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++) {
            if(i != 0) {
                System.out.print(" ");
            }
            System.out.print(list.get(i));
        }
    }
    
    public static void Pour() {
        Queue<Bucket> q = new LinkedList<>();
        boolean[][][] visited = new boolean[maxa+1][maxb+1][maxc+1];
        
        Bucket cur = new Bucket(0, 0, maxc);
        q.offer(cur);
        
        while(!q.isEmpty()) {
            cur = q.poll();
            
            // 이미 다룬 상태일 때는 continue
            if(visited[cur.a][cur.b][cur.c])
                continue;
            visited[cur.a][cur.b][cur.c] = true;
            
            // 원하던 경우: a의 물 양이 0 -> 바로 저장
            if(cur.a == 0) list.add(cur.c);
            
            // 그 외 모든 경우:
            // a -> b, b 가득 참
            // a = cur.a - (maxb - cur.b), b = maxb
            if(cur.a+cur.b > maxb)
                q.offer(new Bucket(cur.a+cur.b-maxb, maxb, cur.c));
            // a = 0, b = cur.a + cur.b
            else
                q.offer(new Bucket(0, cur.a+cur.b, cur.c));
            
            if(cur.a+cur.c > maxc)
                q.offer(new Bucket(cur.a+cur.c-maxc, cur.b, maxc));
            else
                q.offer(new Bucket(0, cur.b, cur.a+cur.c));
            
            if(cur.b+cur.c > maxc)
                q.offer(new Bucket(cur.a, cur.b+cur.c-maxc, maxc));
            else
                q.offer(new Bucket(cur.a, 0, cur.b+cur.c));
            
            if(cur.b+cur.a > maxa)
                q.offer(new Bucket(maxa, cur.b+cur.a-maxa, cur.c));
            else
                q.offer(new Bucket(cur.a+cur.b, 0, cur.c));
            
            if(cur.c+cur.a > maxa)
                q.offer(new Bucket(maxa, cur.b, cur.c+cur.a-maxa));
            else
                q.offer(new Bucket(cur.a+cur.c, cur.b, 0));
            
            if(cur.c+cur.b > maxb)
                q.offer(new Bucket(cur.a, maxb, cur.c+cur.b-maxb));
            else
                q.offer(new Bucket(cur.a, cur.b+cur.c, 0));
        }
    }
    
    public static class Bucket {
        int a, b, c;
        Bucket(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}