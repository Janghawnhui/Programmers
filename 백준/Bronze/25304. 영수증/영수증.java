import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        int totalAmount = sc.nextInt();
        int itemCount = sc.nextInt();

        int calculatedTotal = 0;

        for (int i=0; i< itemCount; i++) {
            int price= sc.nextInt();
            int quantity = sc.nextInt();
                calculatedTotal += price * quantity;
        }

                if(calculatedTotal == totalAmount) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
        sc.close();
    }
}