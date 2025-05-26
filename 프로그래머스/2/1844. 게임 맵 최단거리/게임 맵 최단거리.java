import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
                int answer = 0;
        int i = 0;
        int j = 0;
        int[][] visited = new int [maps.length][maps[0].length];
        queue.add(new int[]{i, j});
        int[] pos;
        visited[i][j] = 1;
        while (!queue.isEmpty()) {
            pos = queue.poll();


            i = pos[0];
            j = pos[1];
            //System.out.println(i + " " + j);
            if (j + 1 <= maps[0].length - 1) {
                if (maps[i][j + 1] == 1 && visited[i][j + 1] == 0) {
                    queue.add(new int[]{i, j + 1});
                    visited[i][j + 1] = visited[i][j] + 1;
                }
            }
            if (i + 1 <= maps.length - 1) {
                if (maps[i + 1][j] == 1 && visited[i + 1][j] == 0) {
                    queue.add(new int[]{i + 1, j});
                    visited[i + 1][j ] = visited[i][j] + 1;

                }
            }
            if (i - 1 >= 0) {
                if (visited[i - 1][j] == 0 && maps[i - 1][j] == 1) {
                    queue.add(new int[]{i - 1, j});
                    visited[i - 1][j] = visited[i][j] + 1;
                }
            }
            if (j - 1 >= 0) {
                if (visited[i][j - 1] == 0 && maps[i][j - 1] == 1) {
                    queue.add(new int[]{i, j - 1});
                    visited[i][j - 1] = visited[i][j] + 1;
                }

            }
        }

        if(visited[maps.length-1][maps[0].length - 1] == 0){
            answer = -1;
        }else {
            answer = visited[maps.length - 1][maps[0].length - 1];
        }

        return answer;
    }
}