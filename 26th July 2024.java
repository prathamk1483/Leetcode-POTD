class Pair {
    int node;
    int dist;
    Pair(int n, int d) {
        this.node = n;
        this.dist = d;
    }
}
class Solution {
    int bfs(int start, List<List<Pair>> adj, int threshold, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int dist = current.dist;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int cost = neighbor.dist;

                if (distance[nextNode] > dist + cost && dist + cost <= threshold) {
                    distance[nextNode] = dist + cost;
                    queue.offer(new Pair(nextNode, dist + cost));
                }
            }
        }

        int reachableCount = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] <= threshold && distance[i] != 0) reachableCount++;
        }
        return reachableCount;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int[] reachable = new int[n];
        for (int i = 0; i < n; i++) {
            reachable[i] = bfs(i, adj, distanceThreshold, n);
        }
        int minReachable = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (reachable[i] <= minReachable) {
                minReachable = reachable[i];
                answer = i;
            }
        }
        return answer;
    }
}
