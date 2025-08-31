import java.util.*;

public class Main {
    static int[][] memoization;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int dfs(int x, int y,int n, int[][]box, int answer) {
        if(memoization[x][y]!=0) return memoization[x][y];
        memoization[x][y]=1;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx <0 || ny<0 || n<=nx || n<=ny) continue;
            if(box[nx][ny] <= box[x][y]) continue;

            memoization[x][y] = Math.max(memoization[x][y], dfs(nx, ny, n, box, 0) + 1);
        }
        return memoization[x][y];
    }
    public static void main(String[] args) {
        int answer;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] box = new int[n][n];
        int real_answer=0;
        memoization = new int[n][n];

        for(int i=0; i<n;i++) {
            for(int j =0; j<n;j++) {
                box[i][j] =sc.nextInt();
            }
        }

        for(int i= 0; i<n; i++) {
            for(int j= 0; j<n; j++) {
                answer =dfs(i,j,n, box,0);
                if(real_answer <= answer) {
                    real_answer = answer;
                }
            }
        }
        System.out.println(real_answer);
    }
}