import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x1, 1, i});
            arr.add(new int[]{x2, -1, i});
        }
        // Please write your code here.
        Collections.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        for (int[] points : arr) {
            int v = points[1];
            int idx = points[2];

            if (v > 0) {
                if (set.isEmpty()) {
                    answer += 1;
                }
                set.add(idx);
            }
            else {
                set.remove(idx);
            }
        }

        System.out.print(answer);
    }
}