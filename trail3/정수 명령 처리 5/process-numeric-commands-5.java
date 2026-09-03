import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch(order) {
                case "push_back":
                    arr.add(Integer.parseInt(st.nextToken()));
                    break;
                case "get":
                    int k = Integer.parseInt(st.nextToken());
                    sb.append(arr.get(k - 1)).append('\n');
                    break;
                case "pop_back":
                    if(!arr.isEmpty()) {
                        arr.remove(arr.size() - 1);
                        break;
                    }
                case "size":
                    sb.append(arr.size()).append('\n');
                    break;
            }
        }
        System.out.print(sb);

    }
}