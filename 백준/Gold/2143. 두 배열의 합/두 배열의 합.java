import java.util.*;

public class Main {

    public static long two_pointer(ArrayList<Integer> A, ArrayList<Integer> B, int T) {
        int A_index = 0;
        int B_index = B.size()-1;
        long answer =0;
        while(B_index >=0 && A_index <A.size()) {
            long A_sum =A.get(A_index);
            long B_sum =B.get(B_index);
            long sum=A_sum+B_sum;
            if (sum == T) {
                long A_count = 0; 
                long B_count = 0;

                while (A_index < A.size() && A.get(A_index) == A_sum) {
                    A_count++;
                    A_index++;
                }

                while (B_index >= 0 && B.get(B_index) == B_sum) {
                    B_count++;
                    B_index--;
                }
                answer += A_count * B_count;
            }
            else if (sum < T) {
                A_index++;
            }
            else { // sum > T
                B_index--;
            }
        }
        return answer;
    }
    //Main 시작
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();

        long answer=0;

        int[] A_Array = new int[A];
        for (int i=0; i<A; i++) {
            A_Array[i] = sc.nextInt();
        }

        int B = sc.nextInt();

        int[] B_Array = new int[B];
        for (int i=0; i<B; i++) {
            B_Array[i] = sc.nextInt();
        }

        ArrayList<Integer> A_sum= new ArrayList<>();
        for(int i=0; i<A; i++) {
            int sum =0;
            for(int j =i; j<A; j++) {
                sum +=A_Array[j];
                A_sum.add(sum);
            }
        }
        ArrayList<Integer> B_sum= new ArrayList<>();
        for(int i=0; i<B; i++) {
            int sum=0;
            for(int j =i; j<B; j++) {
                sum +=B_Array[j];
                B_sum.add(sum);
            }
        }

        Collections.sort(A_sum);
        Collections.sort(B_sum);
        answer = two_pointer(A_sum, B_sum, T);

        System.out.println(answer);
    }
}