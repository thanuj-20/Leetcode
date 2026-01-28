import java.util.*;

class Solution {

    static final int INF = 1_000_000_000;

    static class State {
        int r, c, t, cost;
        State(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        int[] ptr = new int[k + 1];

        PriorityQueue<State> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        dist[0][0][0] = 0;
        pq.add(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost != dist[cur.r][cur.c][cur.t]) continue;

            if (cur.r == m - 1 && cur.c == n - 1)
                return cur.cost;

            for (int d = 0; d < 2; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < m && nc < n) {
                    int ncst = cur.cost + grid[nr][nc];
                    if (ncst < dist[nr][nc][cur.t]) {
                        dist[nr][nc][cur.t] = ncst;
                        pq.add(new State(nr, nc, cur.t, ncst));
                    }
                }
            }

            if (cur.t < k) {
                while (ptr[cur.t] < cells.size()
                       && cells.get(ptr[cur.t])[0] <= grid[cur.r][cur.c]) {

                    int[] cell = cells.get(ptr[cur.t]++);
                    int r = cell[1], c = cell[2];

                    if (cur.cost < dist[r][c][cur.t + 1]) {
                        dist[r][c][cur.t + 1] = cur.cost;
                        pq.add(new State(r, c, cur.t + 1, cur.cost));
                    }
                }
            }
        }
        return -1;
    }
}
