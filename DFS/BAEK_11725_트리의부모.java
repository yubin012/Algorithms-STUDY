import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_11725_트리의부모 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parentV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 노드의 개수
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];

        visited = new boolean[N + 1];
        parentV = new int[N + 1];

        // 배열의 각 요소가 List 이므로
        // 인덱스 마다 리스트 공간 할당
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        parentV[1] = 1; // 1의 부모는 자기 자신

        // n 번 노드의 부모 노드가 정해져있으면, 그 후의 노드들은 전부 자식 노드로 두어야함.

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());

            tree[u1].add(u2);
            tree[u2].add(u1);

        }

        DFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(parentV[i]).append("\n");
        }

        System.out.println(sb);

    }

    /*
     * static void findParent(int v1) {
     * if (!visited[v1]) { // 아직 방문하지 않은 노드라면.
     * // 자식 노드들의 부모 설정
     * visited[v1] = true; // 부모 방문
     * for (int i = 0; i < tree[v1].size(); i++) {
     * int child = tree[v1].get(i);
     * if (child != 1 && !visited[child]) {
     * parentV[child] = v1;
     * findParent(child);
     * visited[child] = true;// 부모 정해짐
     * }
     * }
     * }
     * }
     */

    static void DFS(int node) {
        visited[node] = true; // 방문노드 = 부모 노드
        for (int child : tree[node]) {
            if (!visited[child]) {
                parentV[child] = node;
                DFS(child);
            }
        }
    }
}
