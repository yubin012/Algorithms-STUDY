package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_9663_NQueen {
    static int[][] chess;
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        chess = new int[N][N];
        // 퀸은 한 행에 한 개

        // 0번째 행에 대해 i열 위치 케이스 탐색

    }

    //
    static void backtrack(int row, int i) {
        if (cnt == N) {

        }

        /*
         *
         */
        for (int j = 0; j < N; j++) {

        }

    }

    static boolean checkQueen() {

    }

}
