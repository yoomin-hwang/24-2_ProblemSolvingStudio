import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int ans = first * second;
        int temp = 0;
        
        for(int i=0; i<3; i++) {
            temp = first * (second % 10);
            System.out.println(temp);
            second /= 10;
        }
        
        System.out.println(ans);
    }
}