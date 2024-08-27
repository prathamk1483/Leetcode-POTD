import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        if (start_node == end_node) return 1.0;
        List<Pair>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph[u].add(new Pair(v, prob));
            graph[v].add(new Pair(u, prob));
        }
        double[] probs = new double[n];
        Arrays.fill(probs, 0);
        probs[start_node] = 1.0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start_node);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair neighbor : graph[node]) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.prob;
                if (probs[node] * edgeProb > probs[nextNode]) {
                    probs[nextNode] = probs[node] * edgeProb;
                    q.add(nextNode);
                }
            }
        }
        return probs[end_node];
    }
    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
