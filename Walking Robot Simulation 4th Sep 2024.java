import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0;
        Set<String> obs = new HashSet<>();
        for (int[] i : obstacles) obs.add(i[0] + " " + i[1]);
        int x = 0, y = 0, maxDist = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int i : commands) {
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    int nx = x + dirs[direction][0];
                    int ny = y + dirs[direction][1];
                    if (obs.contains(nx + " " + ny)) break;
                    x = nx;
                    y = ny;
                }
                maxDist = Math.max(maxDist, x * x + y * y);
            } else if (i == -1) { 
                direction = (direction + 1) % 4;
            } else if (i == -2) { 
                direction = (direction + 3) % 4;
            }
        }

        return maxDist;
    }
}
