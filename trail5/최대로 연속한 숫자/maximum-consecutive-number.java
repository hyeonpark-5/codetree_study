import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, Integer> lens = new TreeMap<>();

    
    static void add(int len) {
        if (len <= 0) return;
        lens.put(len, lens.getOrDefault(len, 0) + 1);
    }

    
    static void remove(int len) {
        if (len <= 0) return;
        int cnt = lens.get(len);
        if (cnt == 1) lens.remove(len);
        else lens.put(len, cnt - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 지워진 수 + 양쪽 벽
        TreeSet<Integer> removed = new TreeSet<>();
        removed.add(-1);
        removed.add(n + 1);

        
        add(n + 1);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            int l = removed.lower(x);
            int r = removed.higher(x);

            remove(r - l - 1);  
            add(x - l - 1);      
            add(r - x - 1);      
            removed.add(x);

            sb.append(lens.isEmpty() ? 0 : lens.lastKey()).append('\n');
        }
        System.out.print(sb);
    }
}