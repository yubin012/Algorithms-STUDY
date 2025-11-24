package 자료구조.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BAEK_10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int c = Integer.parseInt(st.nextToken());

            int idx = 1;

            if (map.containsKey(c)) {
                int d = map.getOrDefault(c, 0);
                map.put(c, ++d);
            } else {
                map.put(c, idx);
            }

        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(c, 0) + " ");
        }

        System.out.println(sb);

    }
}
