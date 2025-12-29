import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1987_알파벳 {

    /*
     * 1. 방문처리
     * 2. DFS(next)
     * 3. 방문 해제(backtracking)
     */

    static char[][] board;
    static boolean[] visited = new boolean[26]; // A-Z

    static int R, C;

    //
    static int vx[] = { 1, -1, 0, 0 };
    static int vy[] = { 0, 0, 1, -1 };

    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String c = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = c.charAt(j);
            }
        }

        DFS(0, 0, 1);

        System.out.println(max);
    }

    // 대문자 A = 65

    static void DFS(int x, int y, int cnt) {

        int idx = board[x][y] - 65;
        visited[idx] = true;

        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + vx[i];
            int ny = y + vy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            } // 범위 체크

            int ndx = board[nx][ny] - 65;

            if (!visited[ndx]) {
                DFS(nx, ny, cnt + 1);
            }
        }

        // 백트래킹
        visited[idx] = false;

    }

}
