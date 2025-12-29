import java.util.*;
import java.io.*;

public class BAEK_1018_체스판다시칠하기 {

    static String[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        input = new String[N][M];

        // 주어진 보드 입력 받기
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().split("");
        }

        ArrayList<Integer> repaintCnt = new ArrayList<>();

        // 가능한 체스판 크기만큼 자르기
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int n1 = firstB(i, j);
                int n2 = firstW(i, j);

                repaintCnt.add(Math.min(n1, n2));
            }
        }

        System.out.println(Collections.min(repaintCnt));

    }

    // 왼쪽 상단 첫번째칸이 블랙인 경우
    static int firstB(int x, int y) {
        int cnt = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) { // 인덱스가 짝짝 or 홀홀인 경우가 블랙이여야함.
                    if (!input[i][j].equals("B")) {
                        cnt++;
                    }
                } else {
                    if (!input[i][j].equals("W")) {
                        cnt++;
                    }
                }

            }
        }
        return cnt;
    }

    // 첫 번째 칸이 W인 체스판으로 만들기 위한 칠하기 횟수 계산
    static int firstW(int x, int y) {
        int cnt = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) { // 예상 색이 'W'
                    if (!input[i][j].equals("W")) {
                        cnt++;
                    }
                } else { // 예상 색이 'B'
                    if (!input[i][j].equals("B")) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
