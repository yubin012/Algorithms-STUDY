package 다익스트라;

import java.io.*;
import java.util.*;

import javax.swing.plaf.nimbus.State;

public class test1 {
    // visited 사용 안하는 방식 == 구버전 그냥 스킵하는 방식

    // dist[]
    // priorityQueue 사용
    // 구버전 스킵

    /** 간선(인접 리스트) 표현: u -> to, 비용 w */
    // 인접 리스트 - > 해당 노드와 연결되어 있는 노드들을 리스트로 쭉 붙임.

    /* 자료구조를 위한 내부 클래스 선언 */
    static class Edge {
        int to;
        int w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State {
        int node;
        long dist;

        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static final long INF = Long.MAX_VALUE / 4;

    static int N, M;
    static List<Edge>[] graph;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수

        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w)); // 유향
            // graph[v].add(new Edge(u, w)); // 무향이면 추가
        }
        dist = new long[N + 1];

        // 다익스트라 실행
        dijkstra(start);

        // 결과 출력: 도달 불가면 INF 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] >= INF / 2)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append('\n');
        }
        System.out.print(sb);

    }

    static void dijkstra(int start) {

        // 1. 거리 배열 초기화
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 2. 우선순위큐(최소 힙)
        // dist가 작은 State가 먼저 나오도록 Comparator 지정
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.dist));

        // 시작점 삽입
        pq.offer(new State(start, 0));

        // 3. PQ 가 빌때까지 반복
        while (!pq.isEmpty()) {
            State cur = pq.poll(); // PQ에서 dist가 가장 작은 상태를 꺼낸다
            int now = cur.node;
            long d = cur.dist;

            if (d != dist[now])
                continue;

            /**
             * 4) 완화(relaxation)
             * now에서 갈 수 있는 모든 간선을 확인하면서,
             * dist[next] > dist[now] + w 이면 더 짧은 경로를 찾은 것이므로 갱신한다.
             */

            for (Edge e : graph[now]) {
                int next = e.to;
                long nd = d + e.w;

                if (nd < dist[next]) {
                    dist[next] = nd;

                    // 갱신된 정보를 PQ 에 넣는다(PQ 가 알아서 dist 가 작은 것부터 먼저 처리하게 된다)
                    pq.offer(new State(next, nd));
                }

            }

        }

    }
}
