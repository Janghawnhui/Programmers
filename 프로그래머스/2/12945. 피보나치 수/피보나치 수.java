class Solution {
    public int solution(int n) {
        int answer=0;

        int fn_0=0;// f(0)
        int fn_1=1;// f(1)
        int count =1;

        while(count <n) {
            answer = (fn_0 + fn_1) % 1234567;
            fn_0 = fn_1 % 1234567;
            fn_1 = answer % 1234567;
            count++;
        }

        return answer  % 1234567;

    }
}