import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer;
    static boolean[] visited;

    static void dfs(int x) {
        for (int i : graph.get(x)) {
            if(!visited[i]) {
                visited[i] = true;
                answer += 1;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
         
        visited[1] = true;
        dfs(1);
        System.out.print(answer);
    }
}