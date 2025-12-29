package DP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEK_1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] hap = new int[N]; // 연속된 수들의 합
        boolean[] checkNegative = new boolean[N]; // 합이 음수가 되는지 체크 - 음수가 된다면 해당 원소는 더하지 못함.

        // 처음 원소 초기화
        hap[0] = arr[0];
        if (hap[0] < 0) {
            checkNegative[0] = false;
        }

        ArrayList<Integer> max = new ArrayList<>();
        max.add(hap[0]);

        for (int i = 1; i < N; i++) {
            if (checkNegative[i - 1]) { // 앞의 원소가 잘리지 않고 연속된 상태로 더해짐
                hap[i] = arr[i] + hap[i - 1];
            } else { // 앞의 수열이 끝났으므로 이번 원소부터 새로운 수열 시작
                hap[i] = arr[i];
            }

            if (hap[i] < 0) { // 원소의 합이 음수가 된다면 i번째 원소는 더하지 못하고 수열 끝내기.
                checkNegative[i] = false;
            }

            if (hap[i - 1] < hap[i]) { // 맥스값이 갱신될때마다 추가
                max.add(hap[i]);
            }

        }

        Collections.sort(max);

        System.out.println(max.get(max.size() - 1));
    }

}
