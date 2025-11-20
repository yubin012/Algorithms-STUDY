import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.*;

// 최단거리 문제는 DFS 가 아닌  BFS 로 풀어야 함.

public class BAEK_2178_미로탐색 {
    /*
     * visited 만들기
     * dx/dy 만들기
     * Queue에 시작점 넣기
     * while (!q.isEmpty())
     * 4방향 이동 후 유효성 체크
     * 도착하면 dist 반환
     */

    // 시작점은 (1,1)
    // (N,M) 까지의 최단 거리 구하기.

    static int N;
    static int M;

    // 방향 벡터 설정. 상 하 우 좌
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    // int 형 미로 배열
    static int[][] Map;

    // 현재 위치까지의 최단 거리 저장할 배열
    static int[][] dist;

    // 방문했는지 저장할 배열
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        } // 미로 칸 입력 받기

        BFS(0, 0); // 1,1 에서부터 시작.

        // 인덱스는 원하는 위치에서 각 -1 만큼 해줘야함.
        // (N,M) 까지의 최단 거리 구하기
        System.out.println(dist[N - 1][M - 1]);

    }

    static void BFS(int x, int y) {
        // BFS 는 큐로 구현해야함.
        // why? 큐는 선입선출의 구조로
        // 각 계층(너비가 작은 애들 먼저 도달 후) 먼저 거리 계산해주어야함.

        Deque<int[]> q = new ArrayDeque<>();

        visited[x][y] = true; // 방문처리
        dist[x][y]++; // 시작점의 거리 +1
        q.offer(new int[] { x, y }); // 큐에 방문 위치 삽입

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    // 좌표값이 범위 밖이면
                    continue;
                }
                if (Map[nx][ny] == 0) {
                    // 벽이면 못지나감.
                    continue;
                }
                if (visited[nx][ny]) {
                    // 이미 지나간 길이면
                    continue;
                }

                visited[nx][ny] = true;
                dist[nx][ny] = dist[cx][cy] + 1;
                q.offer(new int[] { nx, ny });
            }

        }

    }
}
