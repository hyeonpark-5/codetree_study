import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();


      int n = Integer.parseInt(br.readLine());
      long[][] arr = new long[n][2];

      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long cnt = Long.parseLong(st.nextToken());
        long val = Long.parseLong(st.nextToken());
        arr[i][0] = val;
        arr[i][1] = cnt;
        
      }

      Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

      ArrayDeque<long[]> q = new ArrayDeque<>();
      for(long[] a : arr) {
        q.addLast(a);
      }

      long answer = 0;
      while(!q.isEmpty()) {
        if(q.size() == 1) {
            answer = Math.max(answer, q.peekFirst()[0] * 2);
            break;
        }

        long[] left = q.peekFirst();
        long[] right = q.peekLast();

        long res = Math.min(left[1], right[1]);
        answer = Math.max(answer, left[0] + right[0]);

        left[1] -= res;
        right[1] -= res;

        if(left[1] == 0) {
            q.pollFirst();
        }
        if(right[1] == 0) {
            q.pollLast();
        }
      }

      System.out.print(answer);


    }
}