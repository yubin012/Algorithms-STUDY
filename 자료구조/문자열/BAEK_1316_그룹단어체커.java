package 자료구조.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_1316_그룹단어체커 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            groupcheck(str[i]);
        }

        System.out.println(cnt);
    }

    static void groupcheck(String s) {
        boolean[] use = new boolean[26]; // a~Z 97 ~ 122
        int idx = 0;
        boolean check = true;

        while (idx < s.length()) {
            int asc = s.charAt(idx) - 97;

            if (!use[asc]) {
                use[asc] = true;
            } else { // 이미 사용한 문자라고 판단되면
                if (s.charAt(idx) != s.charAt(idx - 1)) {
                    // 바로 전 문자랑 비교해야함
                    // 다르다면 연속해서 나타닌 것이 아닌 떨어져서 나타난것.
                    check = false;
                    break; // 따라서 그룹 단어가 아니므로 탐색 종료
                }
            }

            idx++;
        }

        if (check) {
            cnt++;
        }
    }
}
