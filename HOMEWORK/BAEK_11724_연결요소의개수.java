/*
 * 정점의 개수 N 간선의 개수 M (방향없는 그래프)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_11724_연결요소의개수 {

    /*
     * 1. 그래프를 인접리스트로 표현하기
     * 2. 방문 여부를 저장할 visited[] 배열 필요
     * 3. 1번 노드부터 N번 노드를 순회하면서 방문하지 않은 노드를 발견할때마다
     * 그 노드로부터 탐색(DFS or BFS) 시작
     * 4. 탐색이 끝나면 하나의 연결 요소를 모두 방문한 것 -> count++
     */

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 개수
        int N = Integer.parseInt(st.nextToken());

        // 간선 개수
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        } // 인접리스트로 먼저 그래프 받기.

        int cnt = 0;

        for (int i = 1; i <= N; i++) { // 1번노드부터 탐색 시작.
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int node) {
        visited[node] = true;
        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n);
            }
        }

    }
}
