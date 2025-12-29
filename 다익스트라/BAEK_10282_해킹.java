package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_10282_해킹 {

    static class Node implements Comparable<Node> {
        int with; // 감염된 컴퓨터
        int time; // 감염까지의 시간

        Node(int with, int time) {
            this.with = with;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }

    }

    static int[] cost; // 해당 컴퓨터가 감염될때까지 걸리는 시간
    static List<Node>[] computer; // 각 N 개의 컴퓨터의 의존성과 감염시간 정보 저장할 인접리스트
    static boolean[] visited; // 이미 감염된 컴퓨터는 또 다시 감염x
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int D = Integer.parseInt(st.nextToken()); // 의존성 개수
            int C = Integer.parseInt(st.nextToken()); // 시작 컴퓨터 번호

            computer = new ArrayList[N + 1];

            for (int k = 1; k <= N; k++) {
                computer[k] = new ArrayList<>();
            }

            visited = new boolean[N + 1];
            cost = new int[N + 1];

            for (int j = 0; j < D; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 김염 컴퓨터
                int b = Integer.parseInt(st.nextToken()); // 의존 대상
                int s = Integer.parseInt(st.nextToken()); // 감염까지의 시간

                computer[b].add(new Node(a, s));
            }

            dijktstra(C);

            int cnt = 0;
            int maxTime = 0;
            // 컴퓨터 중 감염된 컴퓨터 찾기
            for (int l = 1; l <= N; l++) {
                if (cost[l] != INF) {
                    cnt++;
                    if (cost[l] > maxTime) {
                        maxTime = cost[l];
                    }
                }
            }

            sb.append(cnt).append(" ").append(maxTime).append("\n");

        }

        System.out.println(sb);
    }

    static void dijktstra(int start) {
        // 다익스트라 초기화 상태 만들어주기
        Arrays.fill(visited, false);
        Arrays.fill(cost, INF);
        cost[start] = 0; // 처음 감염된 노트북의 감염시간은 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 처음 컴퓨터 정보 큐에 넣어주기

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int a = cur.with;
            int s = cur.time;

            if (visited[a]) {
                continue;
            }

            visited[a] = true;

            for (Node next : computer[a]) { // a번에 의존하는 컴퓨터(곧 감염될 애들) 꺼내기
                int nextA = next.with;
                int newCost = s + next.time;
                if (newCost < cost[nextA]) {
                    cost[nextA] = newCost;
                    pq.offer(new Node(nextA, newCost));
                }
            }

        }

    }
}
