package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N + 1]; // 1 ~ N 사용
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // N이 1, 2처럼 작은 경우를 위해 처리
        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        int[] dp = new int[N + 1];

        // base case
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(
                    dp[i - 1], // i번째 안 마심
                    Math.max(
                            dp[i - 2] + wine[i], // i번째만 마심
                            dp[i - 3] + wine[i - 1] + wine[i] // i-1, i 마심
                    ));
        }

        System.out.println(dp[N]);
    }
}
