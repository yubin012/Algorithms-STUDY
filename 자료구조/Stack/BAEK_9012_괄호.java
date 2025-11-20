package 자료구조.Stack;

import java.io.*;
import java.util.*;

public class BAEK_9012_괄호 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            if (findVPS(s)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }

        System.out.println(sb);
    }

    static boolean findVPS(String[] srr) {
        Stack<String> stack = new Stack<>();
        // stack 에는 ( 열린괄호만 넣음.
        for (int i = 0; i < srr.length; i++) {
            if (srr[i].equals(")")) { // ) 이 나오면 반드시 (를 뺴야함
                if (!stack.isEmpty()) {
                    stack.pop();
                } else { // 만약 스택에 뺄 ) 가 없다면 짝이 맞지 않아서 NO
                    return false;
                }
            } else {
                stack.push(srr[i]);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
