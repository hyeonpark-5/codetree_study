import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int n;
    static int m;
    static int[][] board;
    static int[][] visited;

    static void dfs(int x, int y) {
        
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                if (board[nx][ny] == 1 && (visited[nx][ny] == 0)) {
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = 1;
        dfs(0, 0);
        System.out.println(visited[n - 1][m - 1]);
    
    }
}