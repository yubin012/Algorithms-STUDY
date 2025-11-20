package 자료구조.정렬;

import java.io.*;
import java.util.*;

public class BAEK_11650_좌표정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new int[] { x, y });
        }

        // Comparator는 return 값에 따라 a 위치가 달라짐. 음수=앞, 양수=뒤
        // 위는 공식이므로 외우자

        // Collections 와 Arrays 의 차이 : arr 이 List 이냐 배열이냐
        Collections.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // x값이 같을땐 y 같으로 정렬 : a[1]이 크면 a[1] 은 뒤에 배치됨.
            }
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] xy : arr) {
            sb.append(xy[0] + " ").append(xy[1] + "\n");
        }

        System.out.println(sb);

    }

}
