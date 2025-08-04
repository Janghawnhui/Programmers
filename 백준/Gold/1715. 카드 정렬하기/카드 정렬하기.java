import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer =0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //List<Integer> numbers = new ArrayList<>();
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            numbers.add(sc.nextInt());
        }

       while(numbers.size() > 1) {
            //Collections.sort(numbers);
            int first = numbers.remove();
            int second = numbers.remove();
            int sum = first + second;
            answer = answer + sum;
            numbers.add(sum);
        }
        System.out.println(answer);
    }
}