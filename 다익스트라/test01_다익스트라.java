package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test01_다익스트라 {
    // 그래프 간선용
    static class Node {
        // 그래프의 간선을 표현하는 클래스
        int to; // 도착 정점 번호
        int cost; // 간선 가중치(거리, 비용 등)

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    // 우선순위 큐 상태용: 우선순위 큐에 넣을 상태 정보
    // 어떤 정점까지의 현재 거리(dist) 를 담는다.

    static class State implements Comparable<State> {
        int node; // 정점 번호
        int dist; // 시작점부터 해당 노드까지의 알려진 최단 거리

        State(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        // 우선순위 큐에서 dist 가 작은것이 먼저 나오도록 정렬 기준 범위
        @Override
        public int compareTo(State o) {
            // 거리를 기준으로 정렬되게 오버라이드
            return Integer.compare(this.dist, o.dist);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    static int N, M;
    static List<Node>[] graph; // 인접 리스트로 표현한 그래프
    static int[] dist; // dist[i] = 시작점에서 i까지의 최단 거리
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 예시 입력: N(정점 수), M(간선 수), start(시작 정점)
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        // M개의 줄에 걸쳐서 u v w가 들어온다고 가정(u -> v, 가중치 w)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            // 무방향 그래프라면 아래 한 줄도 추가해야 함:
            // graph[v].add(new Node(u, w));
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        dijktstra(start);

    }

    static void dijktstra(int start) {
        // 초기화 상태
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;

        // 현재까지의 거리가 가장 짧은 정점 정보를 먼저 꺼내기 위해 우선순위 큐 사용
        PriorityQueue<State> pq = new PriorityQueue<>();
        // 시작 정점 상태를 우선순위 큐에 넣음
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            // 현재까지의 거리가 가장 짧은 정점 꺼내기(그리디)
            State cur = pq.poll();
            int now = cur.node;

            // 이미 최단 거리가 확정된 정점이면 패스 (중복 제거)
            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            // 현재 정점(now)에서 인접한 모든 정점(next.to)을 확인
            for (Node next : graph[now]) {
                int newDist = dist[now] + next.cost;

                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist; // 최단 거리 테이블 갱신

                    // 갱신된 정보를 우선순위 큐에 다시 넣음
                    pq.offer(new State(next.to, newDist));
                }
            }
        }
    }
}
