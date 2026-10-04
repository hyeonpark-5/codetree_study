import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] visited;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int x) {
        if (x == n) {
            for (int ans : answer) {
                sb.append(ans).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == 0) {
                answer.add(i);
                visited[i] = 1;
                dfs(x + 1);
                answer.remove(answer.size() - 1);
                visited[i] = 0;
            }
        }

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new int[n + 1];
        dfs(0);
        System.out.print(sb);
    }
}