class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        //denom1 과 denom2는 같아야함
        int denom3=0, denom4=0;
        int numer3=0, numer4=0;
        int numsumsum=0, denomnom=0;
        
        int numsum=0;
        int denomsum=0;

            denom3 = denom1*denom2;
            numer3 = numer1*denom2;
            
            denom4 = denom2*denom1;
            numer4 = numer2*denom1;
            
            numsum = numer3+numer4;// 128
            
            for(int i=1 ; i<=numsum||i<=denom3 ; i++){
                if(numsum % i ==0 && denom3 % i ==0) {
                    numsumsum = numsum/i;
                    denomnom =  denom3/i;
                }
            }
         
        

        int[] answer= new int[]{numsumsum, denomnom};
         return answer;
    }
}