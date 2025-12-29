import java.io.*;
import java.util.*;

public class BAEK_1417_국회의원선거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 다솜이 제외 N-1 명

        ArrayList<int[]> arr = new ArrayList<>();

        int x = Integer.parseInt(br.readLine()); // 다솜이 득표수만 따로 저장

        // 나머지 n-1 명에 대해
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr.add(new int[] { i, n }); // 기호 번호, 득표수 저장
        }

        arr.sort((a, b) -> b[1] - a[1]); // 득표수값으로 정렬

        int plus = 0; // 다솜이가 조작할 득표 수

        // 5 7 7
        // 6 6 7
        // 7 6 6

        // 10 10 10 10
        // 11 9 10 10

        while (!arr.isEmpty() && arr.get(0)[1] >= x) {
            x++;
            arr.get(0)[1]--; // 배열이므로 참고형 객체 바로 감소 가능
            plus++;

            arr.sort((a, b) -> b[1] - a[1]);

            if (arr.get(0)[1] < x) {
                arr.remove(0);
            }
        }

        System.out.println(plus);

    }
}
