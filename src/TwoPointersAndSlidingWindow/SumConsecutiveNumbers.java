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
        int front = 0, rear = 1;
        sum += input[front];
        while (rear < n && front <= rear) {
            if (sum == m) {
                answer++;
                sum += input[rear++];
                sum -= input[front++];
            } else if (sum < m) {
                sum += input[rear++];
            } else sum -= input[front++];
        }

        return answer;
    }
}
