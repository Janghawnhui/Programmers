class Solution {
    public int[] solution(long n) {
        int num =0;
        String[] str= Long.toString(n).split("");
        int[] answer = new int[str.length];

        for(int i=str.length-1; i>=0; i--) {
            num = Integer.parseInt(str[i]);
            answer[str.length-1-i] = num;
        }

        return answer;
    }
}