import java.io.*;
import java.util.*;

public class BAEK_16916_부분문자열 {
    static String[] s;
    static String[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine().split("");

        p = br.readLine().split("");

        boolean answer = false;

        for (int i = 0; i < s.length; i++) {
            // baekjoon joo // 8-4 = 4 남은 문자 개수 4개. p 의 문자 개수 3개.
            if (s[i].equals(p[0]) && s.length - i >= p.length) {
                answer = findEqual(i);
                if (answer) {
                    break; // 부분 문자열을 찾으면 더 이상 반복할 필요 없다.
                }
            }
        }

        System.out.println(answer ? 1 : 0);
    }

    static boolean findEqual(int idx) { // 같기 시작한 인덱스 번호 // bacekjoon 과 aek 는 a부터 같으므로
                                        // s[1] 에서 부터 3번 비교시작

        for (int i = 1; i < p.length; i++) { // 첫 번째 문자는 이미 비교가 끝났으므로 1부터 시작
            if (!s[idx + i].equals(p[i])) { // 하나라도 다르면 false 반환
                return false;
            }
        }
        return true; // 끝까지 일치하면 true 반환
    }
}
