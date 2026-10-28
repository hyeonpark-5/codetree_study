import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int mask;
    static int[][] dp;
    static int[][] cost;

    static int dfs(int x, int visited) {
        if (visited == mask) {
            if (cost[x][0] == 0) {
                return INF;
            }
            return cost[x][0];
        }

        if (dp[x][visited] != -1) {
            return dp[x][visited];
        }

        int res = INF;
        for (int i = 0; i < n; i++) {
            if((visited & (1 << i)) == 0 && cost[x][i] != 0 ) {
                res = Math.min(res, cost[x][i] + dfs(i, visited | (1 << i)));
            }
        }
        dp[x][visited] = res;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mask = (1 << n) - 1;
        dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(dfs(0, 1));
    }
}