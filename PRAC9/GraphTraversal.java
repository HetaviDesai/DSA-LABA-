import java.util.*;

public class GraphTraversal {

    static class Graph {
        int vertices;
        List<List<Integer>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Depth First Search - uses Stack
        void DFS(int start) {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();

            stack.push(start);

            System.out.print("DFS: ");

            while (!stack.isEmpty()) {
                int current = stack.pop();

                if (!visited[current]) {
                    visited[current] = true;
                    System.out.print(current + " ");

                    // Add neighbors to stack
                    for (int i = adjList.get(current).size() - 1; i >= 0; i--) {
                        int neighbor = adjList.get(current).get(i);

                        if (!visited[neighbor]) {
                            stack.push(neighbor);
                        }
                    }
                }
            }

            System.out.println();
        }

        // Breadth First Search - uses Queue
        void BFS(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(start);
            visited[start] = true;

            System.out.print("BFS: ");

            while (!queue.isEmpty()) {
                int current = queue.poll();
                System.out.print(current + " ");

                for (int neighbor : adjList.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph(vertices);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.addEdge(u, v);
        }

        int start = sc.nextInt();

        graph.DFS(start);
        graph.BFS(start);

        sc.close();
    }
}
