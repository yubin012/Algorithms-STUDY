package 이분탐색;

import java.util.*;
import java.io.*;

/*
이분탐색은 정렬된 배열/리스트에서 원하는 값을 매우 빠르게 찾는 알고리즘이다.
전제: 배열이 오름차순(또는 내림차순)으로 정렬되어 있어야 함. -> O(nlong)
*/

public class BAEK_1654_랜선자르기 {
    static int[] cutArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 만들어야하는 랜선 개수

        /*
         * 각 랜선의 길이 범위는 2^31-1 라고 주어짐.
         * int 형은 -2^31 ~ 2^31 - 1까지 표현 가능한데
         * 
         * 여러개의 랜선 합을 더하면 int 형의 범위를 초과하게 되므로
         * 랜선의 길이는 long 형으로 나타내야 한다.
         */

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        // 오름차순으로 정렬
        // Collections.sort(arr); - 이 문제에서는 정렬 필요 X

        int maxLen = 0;

        for (int i = 0; i < K; i++) {
            maxLen = Math.max(maxLen, arr.get(i));
        }

        long right = maxLen;
        long left = 1;

        long cutPoint = 0; // cut point 의 최대 길이? arr.get(0) // 가장 작은 값

        // 가능한 mid 값 찾기 - 마지막 while 문까지 도는게 자를 수 있는 가장 큰 mid 값
        while (left <= right) {
            long mid = left + (right - left) / 2; // == (left+right)/2 -> overflow 방지
            long cutN = 0;

            // mid 길이로 잘랐을 때의 총 랜선 개수
            for (int i = 0; i < K; i++) {
                cutN += arr.get(i) / mid; // 주의 : mid = 0 이 안되는지 check.(left 가 1부터 시작하는 이유)
            }

            if (cutN >= N) {
                cutPoint = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(cutPoint);

    }
}
