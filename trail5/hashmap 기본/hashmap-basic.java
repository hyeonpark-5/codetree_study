import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int v = 0;
            if (order.equals("add")) {
                v = Integer.parseInt(st.nextToken());
            }
           

            switch (order) {
                case "add":
                    m.put(k, v);
                    break;
                case "find":
                    if(m.containsKey(k)) {
                        System.out.println(m.get(k));
                    }
                    else {
                        System.out.println("None");
                    }
                   break;
                case "remove":
                    if (m.containsKey(k)) {
                        m.remove(k);
                    }
                    break;
                default:
                    break;
            }

        }

    }
}