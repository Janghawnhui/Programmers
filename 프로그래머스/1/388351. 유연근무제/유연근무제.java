class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
                int schedules_10=0;
                int num =0;
                int answer = 0;
                boolean flag = true;
        for(int i = 0; i<schedules.length; i++) {
                            num =0;
            for(int j =0; j<=6; j++) {

                if(startday == 8) {
                    startday=1;
                }
                schedules_10 = schedules[i]+10;
                if(schedules_10 %100 >=60) {
                    schedules_10 +=40;
                }
                if(schedules_10 >= timelogs[i][j] && startday <=5 ) {
                    num++;

                }
                startday++;
            }
            if(num ==5) {
            answer++;
            }
        }

        return answer;
    }
}