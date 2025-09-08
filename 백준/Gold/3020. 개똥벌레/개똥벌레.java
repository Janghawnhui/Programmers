import java.util.*;

public class Main {
    static int[] cave;
    static int[] down_height;
    static int[] up_height;
    static int[] height;

    //Main 시작
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();

        down_height = new int[H];
        up_height = new int[H];
        height = new int[H];
        cave = new int[N];

        for (int i = 0; i < N; i++) {
            cave[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int count = cave[i];
            if(i%2==0) {
                down_height[count-1]++;
            }
            else {
                up_height[count-1]++;
            }
        }
        for(int i = H-2; i >=0; i--) {
            down_height[i] = down_height[i] + down_height[i+1];
            up_height[i] = up_height[i] + up_height[i+1];
        }
        int min=down_height[0];
        for(int i = 0; i< H; i++) {
            down_height[i] = down_height[i] + up_height[H-i-1];
            min = Math.min(min, down_height[i]);
        }
        int count=0;
        for(int i =0; i<H; i++) {
            if(down_height[i] == min) {
                count++;
            }
        }
        System.out.print(min + " " + count);
    }
}
