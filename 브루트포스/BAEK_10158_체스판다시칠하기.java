package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEK_10158_체스판다시칠하기 {

    static ArrayList<Character>[] arr;
    static int N, M;
    static ArrayList<Integer> value; // 각 정사각형 마다 칠해야하는 값 저장소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        // NM 보드 입력 받기
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i].add(s.charAt(j));
            }
        }

        value = new ArrayList<>();

        // 각 칸마다 8x8 로 잘라서 찾기 (각 끝점에서 자신 포함 최소 8칸은 남아 있어야하므로 범위 -7 로 설정)
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                W_find(i, j); // 맨 왼쪽 위 칸이 흰색인 경우
                B_find(i, j); // 검정색이 경우
            }
        }

        Collections.sort(value); // 리스트를 오름차순으로 정렬

        System.out.println(value.get(0)); // 맨 처음(최소값) 인덱스 출력.

    }

    static void W_find(int i, int j) {
        int cnt = 0;
        // 홀홀 짝짝 자리가 w
        for (int x = i; x < i + 8; x++) {
            for (int y = j; y < j + 8; y++) {
                if (((x - i) % 2 == 0 && (y - j) % 2 == 0) || ((x - i) % 2 == 1 && (y - j) % 2 == 1)) { // 짝짝 또는 홀홀
                    if (arr[x].get(y) == 'B') { // B 인 경우 바꿔 칠해야 하므로 카운트
                        cnt++;
                    }
                } else { // 그 외 자리는 B 이여야 한다.
                    if (arr[x].get(y) == 'W') { // W 인 경우 바꿔 칠해야 하므로 카운트
                        cnt++;
                    }
                }
            }
        }

        value.add(cnt);
    }

    static void B_find(int i, int j) {
        int cnt = 0;
        // 홀홀 짝짝 자리가 B
        for (int x = i; x < i + 8; x++) {
            for (int y = j; y < j + 8; y++) {
                if (((x - i) % 2 == 0 && (y - j) % 2 == 0) || ((x - i) % 2 == 1 && (y - j) % 2 == 1)) { // 짝짝 또는 홀홀
                    if (arr[x].get(y) == 'W') { // W 인 경우 바꿔 칠해야 하므로 카운트
                        cnt++;
                    }
                } else { // 그 외 자리는 W 이여야 한다.
                    if (arr[x].get(y) == 'B') { // B 인 경우 바꿔 칠해야 하므로 카운트
                        cnt++;
                    }
                }
            }
        }

        value.add(cnt);
    }
}
