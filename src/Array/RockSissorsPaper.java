package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class RockSissorsPaper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a_input = new int[n];
        int[] b_input = new int[n];
        for (int i=0; i<n; i++) {
            a_input[i] = scanner.nextInt();
        }
        for (int i=0; i<n; i++) {
            b_input[i] = scanner.nextInt();
        }

        for (char x : RockSissorsPaper.solution(a_input, b_input)) {
            System.out.println(x);
        }
    }

    /**
     * 가위바위보 게임
     * - 두 변수를 서로 비교해야 함
     * - 조건문(if-else)를 사용하되, 한 쪽을 기준으로 조건문을 작성
     * - A=1, A=2, A=3 일 때의 경우로 나누어 비교
     * - 각 조건에서 공통 조건으로 묶을 수 있는 것은 빼내어 한 번만 작성성
     * */
    public static ArrayList<Character> solution(int[] a_input, int[] b_input) {
        ArrayList<Character> answer = new ArrayList<>();

        for (int i=0; i<a_input.length; i++) {
            if (a_input[i] == b_input[i]) {
                answer.add('D');
            } else if (a_input[i] == 1) {
                if (b_input[i] == 2) answer.add('B');
                else answer.add('A');
            } else if (a_input[i] == 3) {
                if (b_input[i] == 1) answer.add('B');
                else answer.add('A');
            } else {
                if (a_input[i] > b_input[i]) answer.add('A');
                else answer.add('B');
            }
        }

        return answer;
    }
}
