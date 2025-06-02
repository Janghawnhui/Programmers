import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] triangle) {
        List<Integer> list = new ArrayList<Integer>();
        int answer=0;

        int fn_0=0;// f(0)
        int fn_1=1;// f(1)
        int count =0;
        int sum =0;
        for(int i = triangle.length-2; i >= 0; i--) {
            for(int j = 0 ; j< triangle[i].length; j++) {

                    fn_0 = triangle[i+1][j];
                    fn_1 = triangle[i+1][j+1];
                    triangle[i][j] = Math.max(fn_0 + triangle[i][j],fn_1 + triangle[i][j]);
                    //System.out.println(triangle[i][j]);
                    answer = triangle[i][j];
            }
        }

        return answer;

    }
}