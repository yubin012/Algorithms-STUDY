package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BAEK_2579_계단오르기 {
    static int N;
    static int[] frr;
    static ArrayList<Integer> maxSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        frr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            frr[i] = Integer.parseInt(br.readLine());
        }

        // 처음 밟을 시작점

        int idx = 0; // (1<=idx <=2)

        // 첫번째 도착점 idx
        while (idx < 2) { // idx = 0 일때, 1일때만
            idx++; // 즉 첫번째 도착계단이 1번째 or 2번째 일때만 가능.
            int cnt = 1;
            int sum = frr[idx];

            dp(idx, cnt, sum);
        }

        System.out.println(findMax());

    }

    static void dp(int idx, int cnt, int sum) {
        if (idx < N) {
            if (cnt == 2 && idx <= N - 2) {
                dp(idx + 2, 1, sum + frr[idx + 2]);
            } else if (cnt < 2) {
                dp(idx + 1, cnt + 1, sum + frr[idx + 1]);
                if (idx <= N - 2) {
                    dp(idx + 2, 1, sum + frr[idx + 2]);
                }
            }
        }

        if (idx == N) {
            maxSum.add(sum);
        }
    }

    static int findMax() {
        int max = 0;
        for (int i = 0; i < maxSum.size(); i++) {
            if (max < maxSum.get(i)) {
                max = maxSum.get(i);
            }
        }

        return max;
    }
}
