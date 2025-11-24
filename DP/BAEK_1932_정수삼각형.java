package DP;

import java.io.*;
import java.util.*;

public class BAEK_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 계산
        // case 1: dp[i][j] = dp[i-1][j-1] + dp[i][j]
        // case 2: dp[i][j] = dp[i-1][j] + dp[i][j]
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {

                int case1 = 0;
                int case2 = 0;

                if (j < 1) { // 0 열이면 case1 존재 x
                    case2 = dp[i - 1][j];
                } else { // N-1 열이면 case2 존재하면 안되지만, 배열이 0 으로 초기화되어있으니 상관 x
                    case1 = dp[i - 1][j - 1];
                    case2 = dp[i - 1][j];
                }

                dp[i][j] += Math.max(case1, case2);

            }
        }

        // 0: 0 0 0 0 0
        // 1: 0 1 0 0 0
        // 2: 0 1 2 0 0
        // 3: 0 1 2 3 0
        // 4: 0 1 2 3 4

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[N - 1][i]);
        }
        System.out.println(ans);
    }
}
