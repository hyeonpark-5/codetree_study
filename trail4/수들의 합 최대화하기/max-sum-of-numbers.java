import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int answer;
    static int[][] board;
    static boolean[] visited;

    static void dfs(int x, int cnt) {
        if (x == n) {
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(x + 1, cnt + board[x][i]);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.print(answer);
    }
}