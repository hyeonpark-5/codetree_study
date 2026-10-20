import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static boolean union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }
        parent[b] = a;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];


        for (int tc = 0; tc < m; tc++) {
            st = new StringTokenizer(br.readLine());
            edges[tc][0] = Integer.parseInt(st.nextToken());
            edges[tc][1] = Integer.parseInt(st.nextToken());
            edges[tc][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        long total = 0;
        int count = 0;

        for(int[] e : edges) {
            if (union(e[0], e[1])) {
                total += e[2];
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }

        System.out.println(total);
    }
}