import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            TreeSet<Integer> tree = new TreeSet<>();

            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char order = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (order =='I') {
                    tree.add(n);
                } else {
                    if (n < 0) {
                        tree.pollFirst();
                    }
                    else {
                        tree.pollLast();
                    }
                }
            }


            if (tree.size() == 0) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(tree.last()).append(' ').append(tree.first()).append('\n');
            }


        }

        System.out.print(sb);

        
    }
}