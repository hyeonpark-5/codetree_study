import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static void initParent(int v) {
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();


       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       parent = new int[n + 1];
       initParent(n);

       for (int tc = 0; tc < m; tc++) {
        st = new StringTokenizer(br.readLine());

        int order = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        

        if (order == 0) {
            union(a, b);
        } 
        else {
            if (find(a) == find(b)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
       }
       System.out.print(sb);
    }
}