import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        double ft = 30.48;
        double mi = 160934;

        double answer_ft = Math.round(9.2 * ft * 10) / 10.0;
        double answer_mi = Math.round(1.3 * mi * 10) / 10.0;

        sb.append("9.2ft = ").append(answer_ft).append("cm").append('\n');
        sb.append("1.3mi = ").append(answer_mi).append("cm");
        
        System.out.print(sb);
    }
}