import java.util.*;

class Solution {
    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost) {

        int n = source.length();
        final long INF = Long.MAX_VALUE / 4;

        // 1️⃣ Map strings to ids
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) id.put(original[i], idx++);
            if (!id.containsKey(changed[i])) id.put(changed[i], idx++);
        }

        int m = idx;
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 2️⃣ Direct edges
        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // 3️⃣ Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 4️⃣ Group conversions by substring length
        Map<Integer, List<int[]>> byLen = new HashMap<>();
        for (String s : id.keySet()) {
            byLen.computeIfAbsent(s.length(), k -> new ArrayList<>());
        }

        for (String s : id.keySet()) {
            int u = id.get(s);
            for (String t : id.keySet()) {
                int v = id.get(t);
                if (s.length() == t.length() && dist[u][v] != INF) {
                    byLen.get(s.length()).add(new int[]{u, v});
                }
            }
        }

        // 5️⃣ DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            // single character match
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // try valid substring lengths only
            for (int len : byLen.keySet()) {
                if (i + len > n) continue;

                String s = source.substring(i, i + len);
                String t = target.substring(i, i + len);

                Integer u = id.get(s);
                Integer v = id.get(t);
                if (u == null || v == null) continue;

                long c = dist[u][v];
                if (c != INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + c);
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
