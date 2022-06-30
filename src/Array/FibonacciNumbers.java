package Array;

import java.util.Scanner;

public class FibonacciNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int x : FibonacciNumbers.solution(n)) {
            System.out.print(x + " ");
        }
    }

    /**
     * 피보나치 수열 문제
     * - 일정한 규칙을 토대로 결과를 만들어야 하는 문제 (수열이 대표적)
     * - 확정된 값은 먼저 결과에 대입한 상태로 로직을 시작하는 게 편하다.
     * */
    public static int[] solution(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;
        for (int i=2; i<n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }
}
