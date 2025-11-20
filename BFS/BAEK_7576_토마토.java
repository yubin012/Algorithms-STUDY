import java.io.*;
import java.util.*;

public class BAEK_7576_토마토 {
    // bfs 는 큐(선입선출)

    static boolean[][] visited;
    static int[][] tomato;
    static int N, M;

    // 상 중 우 왼
    static int[] vx = { 1, -1, 0, 0 };
    static int[] vy = { 0, 0, 1, -1 };

    static Deque<int[]> q = new ArrayDeque<>();

    // 1 : 익은 토마토
    // 0 : 익지 않은 토마토
    // -1: 토마토 없음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 6
        M = Integer.parseInt(st.nextToken()); // 4

        tomato = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        int day = bfs();

        if (NotTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }

    static int bfs() {
        int i, j, day = 1000000;
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            day = ij[2];

            for (int r = 0; r < 4; r++) {
                int cx = i + vx[r];
                int cy = j + vy[r];

                if (cx < 0 || cy < 0 || cx >= M || cy >= N) {
                    continue;
                }

                // 이미 지나간 자리이면(1 or -1)
                if (visited[cx][cy]) {
                    continue;
                }

                // 토마토가 자리에 없으면
                if (tomato[cx][cy] == -1) {
                    visited[cx][cy] = true; // 방문처리만 하고 넘어가기
                    continue;
                }

                // 지나갈 수 있는 0 인 토마토를 1로 바꿔줌.
                tomato[cx][cy] = 1;
                visited[cx][cy] = true;
                // 각 방향에서 큐에 넣어줄 때 day(층)을 넣어줘야함.
                q.offer(new int[] { cx, cy, day + 1 });

            }
        }

        return day;

    }

    static boolean NotTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    return false;
                }

            }
        }

        return true;
    }
}
