package 자료구조.정렬;

import java.io.*;
import java.util.*;

public class BAEK_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        /*
         * 1순위 : 단어의 길이
         * 2순위 : 길이가 같다면 사전순으로
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr.add(s);
        }

        Collections.sort(arr, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }

            return a.length() - b.length();
        });

        StringBuilder sb = new StringBuilder();
        String prev = "";

        for (String s : arr) {
            if (!s.equals(prev)) {
                sb.append(s).append("\n");
            }
            prev = s;
        }

        System.out.println(sb);

    }
}
