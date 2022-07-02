package TwoPointersAndSlidingWindow;

import java.util.Scanner;

public class SumConsecutiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(SumConsecutiveNumbers.solution(n, m, input));
    }

    private static int solution(int n, int m, int[] input) {
        int answer = 0;

        int sum = 0;
        int lp = 0;
        for (int rp = 0; rp<n; rp++) {
            sum += input[rp];
            if (sum == m) answer++;
            else if (sum > m) {
                while (sum > m) {
                    sum -= input[lp++];
                }
                if (sum == m) answer++;
            }
        }

        return answer;
    }
}
