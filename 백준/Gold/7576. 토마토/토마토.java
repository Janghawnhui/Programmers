import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public int solution(int width, int height, int[][] box) {
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        int count = 2;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (queue.isEmpty() == false) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] keep = queue.poll();
                int y = keep[0];
                int x = keep[1];
                if (y > 0 && box[y - 1][x] == 0) {
                    box[y - 1][x] = count;
                    queue.add(new int[]{y-1, x});
                }
                if (y < height - 1 && box[y + 1][x] == 0) {
                    box[y + 1][x] = count;
                    queue.add(new int[]{y + 1, x});
                }
                if (x > 0 && box[y][x - 1] == 0) {
                    box[y][x - 1] = count;
                    queue.add(new int[]{y, x-1});
                }
                if (x < width - 1 && box[y][x + 1] == 0) {
                    box[y][x + 1] = count;
                    queue.add(new int[]{y, x + 1});
                }
            }
            count++;
        }
        int max =0;
        for(int [] i : box) {
            for(int j : i) {
                if(j==0) {
                    return -1;
                }
                if(max<j) {
                    max = j;

                }
            }

        }
        answer = max-1;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();

        int[][] box = new int[height][width];
        for (int i = 0; i < height; i++) {      // 행
            for (int j = 0; j < width; j++) {  // 열
                box[i][j] = sc.nextInt();
            }
        }



        Main sol = new Main();
        int result = sol.solution(width, height, box);

        System.out.println(result);
    }
}
