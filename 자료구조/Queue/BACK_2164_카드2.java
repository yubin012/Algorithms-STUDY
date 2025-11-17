package 자료구조.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BACK_2164_카드2 {
    // 로테이션 같다 꼭
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N = 6 -> 1 2 3 4 5 6
        // 1 2 3 4 5 6 버림
        // 2 3 4 5 6 뒤
        // 3 4 5 6 2 버림
        // 4 5 6 2 뒤
        // 5 6 2 4 버림
        // 6 2 4 뒤
        // 2 4 버림
        // 4 -> 마지막 남은 카드는 4

        // 나감 <- 1 2 3 4 5 6 <- 들어옴

        // 양방향 큐 -> 1부터 나가고 6 쪽으로 들어옴.

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            stack.offer(i);
        }

        while (!stack.isEmpty() && stack.size() > 1) {
            stack.poll(); // 앞에서 삭제
            if (stack.size() == 1) {
                break;
            }
            stack.addLast(stack.poll());
        }

        System.out.println(stack.poll());
    }
}
