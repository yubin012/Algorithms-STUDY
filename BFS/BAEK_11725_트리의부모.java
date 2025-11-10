import java.util.*;
import java.io.*;

public class BAEK_11725_트리의부모 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parentV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parentV = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        } // 각 노드의 배열에 인접리스트 할당

        StringTokenizer st;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parentV[i]).append("\n");
        }

        System.out.println(sb);
    }

    /*
     * [1] 6 ,
     * [2]
     * [3]
     * [4]
     * [5]
     * [6]
     * [7]
     */
    // 큐에 1을 넣는다.
    // 큐에 1을 꺼낸다 -> 현재 노드는 1 . 1의 자식 노드 확인 6 4
    // 6 4 를 큐에 넣는다.

    // 6을 꺼낸다 -> 6의 자식 노드를 확읺ㄴ다. -> 6의 노드는
    //
    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node); // 큐에 부모노드 넣기
        visited[node] = true;
        // 큐에 있는 노드가 없을 때
        while (!q.isEmpty()) {
            int current = q.poll(); // 꺼내면 없어짐
            for (int child : tree[current]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parentV[child] = current;
                    q.add(child);
                }
            }
        }
    }
}

// 1

/*
 * LinkedList 로 큐를 규현할 시
 * peek -> 맨 앞 요소 확인
 * poll -> 맨 앞 요소 꺼내기 (제거됨)
 */