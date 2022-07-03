package TwoPointersAndSlidingWindow;

import java.util.Scanner;

public class SumOfConsecutiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(SumOfConsecutiveNumbers.solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = i + 1;
        }
        int sum = 0, lp = 0;
        for (int rp=0; rp<n; rp++) {
            sum += array[rp];
            if (sum == n) answer++;
            while (sum > n) {
                sum -= array[lp++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        answer -= 1;
        return answer;
    }
}
