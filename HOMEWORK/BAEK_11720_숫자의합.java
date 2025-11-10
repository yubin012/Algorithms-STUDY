import java.io.*;
import java.util.*;

public class BAEK_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String number = br.readLine();
        String[] num = number.split("");

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(num[i]);
        }

        System.out.println(sum);

    }
}
