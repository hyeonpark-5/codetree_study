import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int a = 3;
        int b = 4;
        b = a;
        sb.append(a).append(' ').append(b).append('\n').append(a * b);
        
        System.out.print(sb);
    }
}