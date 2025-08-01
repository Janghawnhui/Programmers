    import java.util.ArrayList;
    import java.util.PriorityQueue;
    import java.util.Scanner;

    class Node {
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx= idx;
            this.cost = cost;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // 노드와 간선의 개수
            int V = sc.nextInt(); //노드 개수
            int E = sc.nextInt(); //간선 개수
            // 출발지점
            int start = sc.nextInt();
            PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
            int[] visited = new int[V+1];

            for(int i=1; i<=V; i++) {
                visited[i] = Integer.MAX_VALUE;
            }
            ArrayList<ArrayList<Node>> graph = new ArrayList<>();

            for (int i =0; i< V +1; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i =0 ; i< E; i++) {
                int a= sc.nextInt();
                int b = sc.nextInt();
                int cost = sc.nextInt();

                graph.get(a).add(new Node(b, cost));
            }

            visited[start] = 0;
            q.add(new Node(start,0));

            while(!q.isEmpty()) {
                int curr = q.peek().idx;
                int cos = q.peek().cost;
                q.poll();

                for(Node node : graph.get(curr)) {
                    if(visited[node.idx] > cos + node.cost) {
                        visited[node.idx] = cos + node.cost;
                        q.add(new Node(node.idx,cos + node.cost));
                    }
                }

            }
            for(int idx =1 ;idx <=V; idx++) {
                if(visited[idx] == Integer.MAX_VALUE) {
                    System.out.println("INF");
                } else
               System.out.println(visited[idx]);
            }


        }
    }
