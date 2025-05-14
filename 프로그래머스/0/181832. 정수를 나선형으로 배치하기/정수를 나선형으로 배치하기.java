class Solution {
    public int[][] solution(int n) {
        int[][] num = new int[n][n];
        int arraynum =1;
        int start = 0;
        int end = n-1;
        while (start <=end) {
            for(int i = start ; i<=end;i++) {
                num[start][i]=arraynum++;
            }
            for(int i=start+1; i<=end; i++) {
                num[i][end]=arraynum++;
            }
            for(int i=end-1; i>=start; i--) {
                num[end][i] = arraynum++;
            }
            for(int i=end-1; i>start; i--) {
                num[i][start]=arraynum++;
            }
            start++;
            end--;
        }

        int[][] answer = num;
        return answer;
    }
}