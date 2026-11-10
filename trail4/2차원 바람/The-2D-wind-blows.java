import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int r1;
    static int r2;
    static int c1;
    static int c2;
    static int[][] board;
    // 상하좌우
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 평균으로 바꾸기
    static void change() {
        int[][] temp = new int[n][m];

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                int sum = board[r][c];
                int count = 1;

                for (int i = 0; i < 4; i++) {
                    int nx = r + dx[i];
                    int ny = c + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    sum += board[nx][ny];
                    count += 1;
                }

                temp[r][c] = sum /count;
            }
        }

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                board[r][c] = temp[r][c];
            }
        }
    }



    // 회전 시키기
    static void rotate() {
        
       int temp = board[r1][c1];

       for (int r = r1; r < r2 ; r++) {
        board[r][c1] = board[r + 1][c1];
       }

       for (int c = c1; c < c2; c++) {
        board[r2][c] = board[r2][c + 1];
       }

       for(int r = r2; r > r1; r--) {
        board[r][c2] = board[r - 1][c2];
       }

       for (int c = c2; c > c1 + 1; c--) {
        board[r1][c] = board[r1][c - 1];
       }

       board[r1][c1 + 1] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken()) - 1;
            c1 = Integer.parseInt(st.nextToken()) - 1;
            r2 = Integer.parseInt(st.nextToken()) - 1;
            c2 = Integer.parseInt(st.nextToken()) - 1;

            rotate();
            change();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                sb.append(board[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
      
    }
}