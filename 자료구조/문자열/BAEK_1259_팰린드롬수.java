package 자료구조.문자열;

import java.io.*;
import java.util.*;

public class BAEK_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        ArrayList<String[]> srr = new ArrayList<>();

        while (!s.equals("0")) {
            s = br.readLine();
            srr.add(s.split(""));

        }

        StringBuilder sb = new StringBuilder();

        // 마지막 0 일 때를 제외하고 각 라인별 문자열에 대해 펠린드롬 검사
        for (int i = 0; i < srr.size() - 1; i++) {
            if (findSame(srr.get(i))) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);

    }

    static boolean findSame(String[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            if (!s[i].equals(s[s.length - 1 - i])) {
                return false;
            }
        }

        return true;
    }
}
