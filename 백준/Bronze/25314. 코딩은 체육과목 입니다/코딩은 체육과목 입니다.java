import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        int num = sc.nextInt();
        int four = num /4;

        for(int i = 1 ; i <= four;i++) {
            System.out.print("long ");
        }
        System.out.print("int");
        sc.close();
    }
}