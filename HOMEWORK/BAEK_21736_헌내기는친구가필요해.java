import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BAEK_21736_헌내기는친구가필요해 {

    static int dx; // 도연이의 위치
    static int dy;

    static int N;
    static int M;

    static int[] vx = { 1, -1, 0, 0 };
    static int[] vy = { 0, 0, 1, -1 };

    static boolean[][] visited;
    static String[][] campus;

    static int meetCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        campus = new String[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.substring(j, j + 1);

                if (campus[i][j].equals("I")) {
                    dx = i;
                    dy = j;
                }
            }
        }

        bfs(dx, dy);

        if (meetCnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(meetCnt);
        }

    }

    static void bfs(int dx, int dy) {
        // 여기는 한번만 실행
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { dx, dy });
        visited[dx][dy] = true;

        // 여기서 bfs 실행
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            // 각 노드에 대해 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int cx = x + vx[i];
                int cy = y + vy[i];

                // 없는 길이면 못감
                if (cx < 0 || cy < 0 || cx >= N || cy >= M) {
                    continue;
                }
                // 이미 지나간 길이면 못감
                if (visited[cx][cy]) {
                    continue;
                }
                // 벽이면 못감
                if (campus[cx][cy].equals("X")) {
                    continue;
                }

                // 지나갈 수 있는 길이면 지나가고, P 면 cnt
                if (campus[cx][cy].equals("P")) {
                    meetCnt++;
                }

                visited[cx][cy] = true;
                q.offer(new int[] { cx, cy });
            } // for 문
        }

    } // bfs
}
