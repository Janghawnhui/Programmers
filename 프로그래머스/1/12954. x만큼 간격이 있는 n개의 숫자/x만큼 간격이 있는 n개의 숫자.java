class Solution {
    public long[] solution(int x, int n) {
        long num =0;
        long[] answer = new long[n];
        for(int i=0; i<=n-1; i++) {
            num = num + x;
            answer[i] = num;
        }
        return answer;
    }
}