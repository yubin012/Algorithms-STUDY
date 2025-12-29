import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEK_2667_단지번호붙이기 {
    static int[][] map;
    static boolean[][] visited;

    static int hometown; // 단지 내의 집 개수

    static int[] vx = { 1, -1, 0, 0 };
    static int[] vy = { 0, 0, 1, -1 };
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> cnt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    hometown = 0;
                    visited[i][j] = true;
                    DFS(i, j);
                    cnt.add(hometown);

                }
            }
        }

        Collections.sort(cnt);

        System.out.println(cnt.size());
        for (int n : cnt) {
            System.out.println(n);
        }

    }

    // 1부터
    static void DFS(int i, int j) {

        hometown++;

        for (int k = 0; k < 4; k++) {
            int nx = i + vx[k];
            int ny = j + vy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
}
