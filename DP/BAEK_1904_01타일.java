package DP;

import java.util.*;
import java.io.*;

// 시간 제한이 0.75초로 제한되어 있음.
// 1초보다 작음

// 입력 수 백만 
// O(N) -> 가능
// o(NlogN) -> 이백만까지 -> 가능

// 현재 타일의 종류 : 1 또는 00 
public class BAEK_1904_01타일 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MOD = 15746;

        // 만들 수 있는 타일에 00 또는 1을 붙여 새로운 타일을 만들 수 있음.

        // 즉 크기가 N 인 수열을 만들고 싶다면
        // 크기가 N-1 일때에 + 1 만 붙이거나
        // 크기가 N-2 일때에 + 00 만 붙이면 된다.

        int[] dp = new int[N + 1];

        dp[1] = 1;

        if (N > 1) {
            dp[2] = 2;
        }

        for (int i = 3; i <= N; i++) {
            // 피보나치수열
            // 피보나치수열은 숫자가 커지는 속도가 기하급수적이라 매우 빠르다.
            // 따라서 n = 50 만 되도 long 범위를 벗어나려고 함. -> 메모리 초과 발생

            // 따라서 여기서 사용해야하는 것이 모듈러 법칙
            // (A+B) mod C = ((A mod C) + (B mod C)) mod C

            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[N]);

    }

}
