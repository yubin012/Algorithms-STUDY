package 자료구조.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_10799_쇠막대기 {
    // 적어도 한개는 무조건 잘라야한다.
    // 중첩 괄호가 무조건 나와야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int N = s.length();

        char[] bracket = new char[N];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            bracket[i] = s.charAt(i);

            if (bracket[i] == '(') {
                stack.push(bracket[i]);
            } else { // ")" 닫힌 괄호면 - 1. 레이저 2. 막대기 끝
                stack.pop();
                if (bracket[i - 1] == '(') { // 연속으로 괄호쌍 완성이면 레이저
                    cnt += stack.size();
                } else {// 막대 끝이면
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
