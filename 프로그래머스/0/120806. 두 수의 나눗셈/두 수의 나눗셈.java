class Solution {
    public int solution(int num1, int num2) {
        double result = (double)num1/num2;
        System.out.println(result);
        double answer = result * 1000;
        return (int)answer;
    }
}