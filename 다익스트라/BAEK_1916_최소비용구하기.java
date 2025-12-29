package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
import java.util.PriorityQueue;

// 다익스트라는 시작 정점에서 다른 노드들까지의 각각 최소거리를 구하는 알고리즘이다.

public class BAEK_1916_최소비용구하기 {

    // 인접리스트(간선 표현)
    static class Edge {
        int to; // 도착 정점 번호
        int w; // 간선 가중치(입력받을시 확정)

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    // 우선순위 큐 상태용
    static class State implements Comparable<State> {
        int node; // 도착 정점 번호
        long dist; // 시작점부터 해당 노드까지의 알려진 최단 거리(누적용)

        State(int node, Long dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist); // dist 값이 가장 작은 순으로 먼저 나오게 정렬.
        }

    }

    static int N, M;
    static List<Edge>[] graph;
    static long[] dist; // 누적 거리는 long 으로 선언해야 터질 가능성 예방.

    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(v, w));
        }

        dist = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int fin = Integer.parseInt(st.nextToken());

        // start 점에 연결된 노드들을 따라 최소비용을 구한다.
        dijkstra(start);

        System.out.println(dist[fin]);

    }

    static void dijkstra(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 시작 노드를 우선순위 큐에 넣고 시작한다.
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(start, dist[start]));

        while (!pq.isEmpty()) {
            // 현재 노드에서 최단거리(dist 가 가장 작은)의 노드를 꺼내도록 함.
            State cur = pq.poll();
            int now = cur.node;
            long d = cur.dist;

            if (d != dist[now]) { // 최단거리가 아니라면 다시 꺼내기
                continue;
            }

            for (Edge e : graph[now]) {
                int next = e.to;
                long nd = d + e.w;

                if (nd < dist[next]) {
                    dist[next] = nd;

                    pq.offer(new State(next, nd));
                }
            }
        }
    }
}
