import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[10];    
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 9; i > -1; i--) {
            sb.append(arr[i]);
        }

        System.out.print(sb);
    }
}