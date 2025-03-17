class Solution {
    static class Edge {
        int src, dest, wt; // source node, destination node and weight.

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Step 1 -> create the graph. 
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // graph[i] is the source of the city.
        }

        // loop through the flights[][] extracting the src, dest and wt and adds the corresponsding edge to graph[src].
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int wt = flight[2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    // stores the information about the city in the BFS Traversal.
    static class Info {
        int v, cost, stops; // v is the current city.

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n]; // dist[i] is the minimum cost to reach city i from src.
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // all the cities are the set to unreachable except the src which is set to 0.

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // the starting city is the source which is added with a cost of 0 and 0 stops.

        while (!q.isEmpty()) {
            Info curr = q.poll();

            if (curr.stops > k) continue; 

            for (Edge e : graph[curr.v]) { // relaxation of edges.
                int v = e.dest;
                int newCost = curr.cost + e.wt; // cost to reach v from src.

                // If newCost is lower than the current dist[v], it updates dist[v] and adds v to the queue.
                if (newCost < dist[v]) { 
                    dist[v] = newCost;
                    q.add(new Info(v, newCost, curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}