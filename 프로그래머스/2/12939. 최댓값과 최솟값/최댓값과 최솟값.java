import java.util.*;
import java.lang.Math;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" "); 
        int [] arr = new int[str.length];

        for(int i =0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
             int iMax = arr[0];
             int iMin = arr[0];
        
        for(int i : arr) {
            
            iMax= Math.max(i, iMax);
        }
        for (int i : arr) {
            iMin = Math.min(i, iMin);
        }
        System.out.print(iMin+ " ");
        System.out.print(iMax);

        return iMin + " " + iMax;
    }
}