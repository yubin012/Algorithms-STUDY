package 자료구조.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_1874_스택수열 {

    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Integer> anwser = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // stack 에는 1부터 push 할 것임.

        int N = Integer.parseInt(br.readLine());



        for (int i = 0; i < N; i++) {
            anwser.add(Integer.parseInt(br.readLine()));
        }

        int idx = 1;

        while (idx <= N) {
            if(!stack.isEmpty()){
                break;
            }
            stack.add(idx);
            if()




        }

    }
}
