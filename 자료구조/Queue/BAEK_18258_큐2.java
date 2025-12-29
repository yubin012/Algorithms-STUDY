package 자료구조.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BAEK_18258_큐2 {
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            word(st);
        }

        System.out.println(sb);

    }

    static void word(StringTokenizer st) {
        if (st.countTokens() > 1) { // push
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            dq.add(n);
        } else {
            String s = st.nextToken();

            if (s.equals("pop")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(dq.pollFirst()).append("\n");
                }
            }

            if (s.equals("size")) {
                sb.append(dq.size()).append("\n");
            }

            if (s.equals("empty")) {
                if (dq.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            if (s.equals("front")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(dq.peekFirst()).append("\n");
                }
            }
            if (s.equals("back")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(dq.peekLast()).append("\n");
                }
            }
        }

    }
}
