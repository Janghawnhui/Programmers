class Solution {
    public double solution(int[] arr) {
        double sum=0;
        double answer = 0;
        for(int i =0; i<=arr.length-1; i++) {
            sum = sum + arr[i];
        }
        answer = sum / arr.length;
        
        return answer;
    }
}