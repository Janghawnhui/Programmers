import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int [][]room;
    static int [][]real_room;
    static int [][]real_real_room;
    //Main 시작
    public static void main(String[] args) {
        int answer = 0;
        int[] air_purifier = new int[2];
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();
        room = new int[R][C];

        real_real_room = new int[R][C];

        for(int i=0; i<R; i++) {
            for (int j =0 ;j<C; j++) {
                room[i][j] = sc.nextInt();
                real_real_room[i][j] = room[i][j];
                if(room[i][j] ==-1) {
                    air_purifier[0] = i-1;
                    air_purifier[1] = i;
                }
            }
        }

        while(T!=0) {
            real_room = new int[R][C];
            T--;
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(real_real_room[i][j]!=0&&real_real_room[i][j]!=-1&&real_real_room[i][j]>=5) {
                        int count =0;
                        int num =0;
                        for(int x=0; x<4; x++) {
                            int ny = i + dy[x];
                            int nx = j + dx[x];
                            if (nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
                            if (real_real_room[ny][nx] == -1) continue;
                            num = real_real_room[i][j]/5;
                            real_room[ny][nx]+=num;
                            count++;
                        }
                        real_real_room[i][j]= real_real_room[i][j] -num*count;
                    }
                }
            }
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    real_real_room[i][j]+=real_room[i][j];
                    room[i][j] = real_real_room[i][j];
                }
            }

            for(int i=C-1;i>0; i--) {
                if(room[air_purifier[0]][i-1]==-1) {
                    real_real_room[air_purifier[0]][i] =0;
                    break;
                }
                real_real_room[air_purifier[0]][i]=room[air_purifier[0]][i-1];
            }
            for(int i=C-1;i>0; i--) {
                if(room[air_purifier[1]][i-1]==-1) {
                    real_real_room[air_purifier[1]][i] =0;
                    break;
                }
                real_real_room[air_purifier[1]][i]=room[air_purifier[1]][i-1];
            }

            for(int i=0; i<air_purifier[0]; i++) {
                real_real_room[i][C-1] =room[i+1][C-1];
            }
            for(int i=R-1; i>air_purifier[1]; i--) {
                real_real_room[i][C-1] = room[i-1][C-1];
            }

            for(int i=0; i<C-1; i++) {
                real_real_room[0][i] = room[0][i+1];
                real_real_room[R-1][i] = room[R-1][i+1];
            }

            for(int i=air_purifier[0]-1;i>0; i--) {
                real_real_room[i][0] =room[i-1][0];
            }
            for(int i=air_purifier[1]+1; i<R-1;i++) {
                real_real_room[i][0] = room[i+1][0];
            }
        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                answer+=real_real_room[i][j];
            }
        }
        System.out.print(answer+2);
    }
}