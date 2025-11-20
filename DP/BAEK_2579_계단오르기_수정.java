package DP;

import java.io.*;
import java.util.*;

public class BAEK_2579_계단오르기_수정 {
    // DP 문제

    // 1.DP 배열 설정
    // 2.DP 배열 초기값 정의
    // 3.점화식 세우기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }

        // dp[i] = i번째 계단까지의 최대 합

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        // 3번째 계단
        // 4번째 계단
        // 5번째 계단
        // 6번째 계딴
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }

        System.out.println(dp[N]);

    }
}
