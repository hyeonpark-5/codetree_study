import java.util.*;
import java.io.*;

public class Main {
    static int k, n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int x) {
        if(x == n) {
            for (int a : arr) {
                sb.append(a).append(' ');
                
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[x] = i;
            dfs(x + 1);
        }
    }


}