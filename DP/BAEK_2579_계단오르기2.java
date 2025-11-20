package DP;

import java.io.*;
import java.util.*;

public class BAEK_2579_계단오르기2 {
    static int N;
    static int[] frr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        frr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            frr[i] = Integer.parseInt(br.readLine());
        }

        // 누적합이 최대가 되는 구간을 찾기
        // 1+2
        // 2+1
        // 2+2

        // 완전탐색 -> 2^ N, DP -> N^2
        // N 이 300 이므로 (시간복잡도 제한에서는 N 이 최대 30이어야 완전탐색가능)

        // dp[N];
        // dp[N-1];
        // dp[N-3];

        // dp[N];
        // dp[N-2];
        // dp[N-3] or dp[N-4]

        dp[N] = frr[N];

    }

}
