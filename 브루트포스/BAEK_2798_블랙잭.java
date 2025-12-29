package 브루트포스;

import java.io.*;
import java.util.*;

public class BAEK_2798_블랙잭 {
    // 카드 합이 21을 넘지 않는다.
    // 카드 합을 최대로 만든다.

    // 변형 후
    /*
     * 딜러가 외치는 숫자 M
     * 플레이어는 3장의 카드를 골라 합이 M 은 넘지 않으면서 최대가 되게 만든다.
     * 이때의 합을 출력해라
     */

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        /*
         * 문제 조건: 제한시간 1초
         * N은 100 이햐 -> 100 * 100 * 100 = 1.000,000 (백만) 삼중for문 가능
         * - 시간복잡도 널널
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 수
        N = Integer.parseInt(st.nextToken());
        // M 이하의 최대합 만들기
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = findMax(arr);

        System.out.println(answer);

    }

    static int findMax(int[] arr) {
        int sum = 0;

        int res = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int r = j + 1; r < N; r++) {
                    sum = arr[i] + arr[j] + arr[r];
                    if (sum > res && sum <= M) {
                        res = sum;
                    }
                }
            }
        }

        return res;
    }
}
