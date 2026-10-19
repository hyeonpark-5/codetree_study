import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] grid;
    static int dfs(int x, int y) {
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (grid[nx][ny] == 1) {
                    grid[nx][ny] = 0;
                    cnt += dfs(nx, ny);
                }
            }
        }

        return cnt;
    } 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int res = dfs(i, j);
                    arr.add(res);
                }
            }
        }

        Collections.sort(arr);

        sb.append(arr.size()).append('\n');

        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append('\n');
        }

        System.out.print(sb);
       
    }
}