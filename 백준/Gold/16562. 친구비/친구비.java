import java.util.*;

public class Main {

    static int[] parents;
    static int[] costs;

    static private void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if(A == B) return;

        if(costs[A] <= costs[B]) {
            parents[B]=A;
        } else {
            parents[A]=B;
        }
    }
    static private int find(int a) {
        if ( parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    //Main 시작
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int wallet = sc.nextInt();

        int sum =0;
        parents = new int[n];
        costs = new int[n];

        for(int i=0; i<n; i++) {
            int cost = sc.nextInt();
            parents[i] = i;
            costs[i] =cost;
        }

        for(int i =0; i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a-1, b-1);
        }
        boolean[] count = new boolean[n];
        for(int i =0; i<n;i++) {
            int parent = find(i);
            if(!count[parent]) {
                sum = sum+costs[parent];
                count[parent] =true;
            }
        }
        if(sum<=wallet) {
            System.out.println(sum);
        } else {
            System.out.println("Oh no");
        }
    }
}