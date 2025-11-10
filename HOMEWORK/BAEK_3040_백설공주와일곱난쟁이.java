
import java.util.*;
import java.io.*;

public class BAEK_3040_백설공주와일곱난쟁이 {
    static int[] nine;
    static boolean[] visited;
    static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 9 난쟁이 중 모자에 적힌 합이 100 이 되는 진짜 7명의 난쟁이를 찾아라
         */

        /*
         * 알고리즘: 12 C 10 -> 순서 상관 x -> 조합은 백트래킹(DFS + 재귀 방식) 으로 구현한다.
         */
        nine = new int[9];
        visited = new boolean[9];

        for (int i = 0; i < 9; i++) {
            nine[i] = Integer.parseInt(br.readLine());
        }

        // sum 은 전역으로 설정하면 안됨.
        // 시작 인덱스 0 . 뽑아야할 노드 개수 7
        combination(0, 7, 0);

    }

    // 0 1 2 3 4 5 6 7

    static void combination(int start, int r, int sum) {
        if (finish) {
            return;
        } // 답을 찾았으면 재귀 종료

        if (r == 0) {
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (visited[i]) {
                        System.out.println(nine[i]);
                    }
                }

                finish = true; // 답을 찾았으면 탐색 종료
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            visited[i] = true;
            // sum += nine[i]; -> 현재 함수의 sum 은 유지해야 백트래킹때 문제 없음.
            combination(i + 1, r - 1, sum + nine[i]);
            visited[i] = false;
        }

    }

}
