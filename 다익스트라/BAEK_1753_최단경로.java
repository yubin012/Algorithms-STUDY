package 다익스트라;

import java.io.*;
import java.util.*;

// 다익스트라 
// 가중치는 양수

// 현재까지 알려진 거리 중 가장 작은 거리를 가진 정점부터 -> 그리디
public class BAEK_1753_최단경로 {

    static class Node implements Comparable<Node> {
        int v; // 도착 정점
        int w; // 현재까지의 거리(가중치)

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w; // 우선순위 큐 정렬을 위해 (오름차순)
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph; // 인접 리스트
    static boolean[] visited;
    static int[] dist; // 최단 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 시작 정점
        int startV = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // 정점 u -> v , 가중치 w
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 그래프 입력 받기
            graph[u].add(new Node(v, w));
        }

        dijktstra(startV);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);

    }

    static void dijktstra(int start) {
        // 초기화 상태
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 정점의 거리는 0
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;
            int d = cur.w;

            // 방문한적 있으면(최단거리 확정이면) 스킵
            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Node next : graph[now]) {
                int nextV = next.v;
                int cost = dist[now] + next.w;

                if (cost < dist[nextV]) {
                    dist[nextV] = cost;
                    pq.offer(new Node(nextV, cost));
                }
            }
        }
    }
}
