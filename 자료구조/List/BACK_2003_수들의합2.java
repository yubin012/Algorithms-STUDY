import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0; // 부분집합이 M인 경우의 수
        int sum = 0; // 현재 구한 부분합
        int idx = 0;

        for (int start_idx = 0; start_idx < N; start_idx++) {
            idx = start_idx;
            while (sum < M && idx < N) {
                sum += arrA[idx];
                idx++;
            }
            if (sum == M) {
                cnt++;
            }
            sum = 0;
        }
        System.out.println(cnt);

    }

}
