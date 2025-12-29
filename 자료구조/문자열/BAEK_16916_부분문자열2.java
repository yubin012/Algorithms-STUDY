import java.io.*;

public class BAEK_16916_부분문자열2 {

    static String[] s;
    static String[] p;

    // 자바에서 contains() 는 브루트포스 방식에 가까운 알고리즘을 사용해서 n*m 의 시간복잡도를 가질 수 있음
    // 따라서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine().split("");
        p = br.readLine().split("");

        int sdx = 0;
        int pdx = 0;

        boolean answer = false;

        int tdx = 0; // 현재비교하고 있는 비교 인덱스(커서느낌)

        // babakjoon
        // baj

        while (sdx < s.length && tdx < s.length - p.length) {
            if (s[sdx].equals(p[pdx])) {
                pdx++;
                if (pdx == p.length) {
                    answer = true;
                    break;
                }
                sdx++;

            } else { // 일치하지 않으면
                if (pdx == 0) {
                    sdx++; // sdx 의 다음 인덱스부터 다시 검사
                } else {
                    pdx = 0; // sdx 는 해당 인덱스부터 다시 검사
                }
            }
            tdx = sdx;

        }

        System.out.println(answer ? 1 : 0);

    }
}
