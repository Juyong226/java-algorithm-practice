package TwoPointersAndSlidingWindow;

import java.util.Scanner;

public class MaxSales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(MaxSales.solution(n, m, input));
    }

    private static int solution(int n, int m, int[] input) {
        int answer = 0;

        int sale = 0;
        for (int i=0; i<m; i++) {
            sale += input[i];
        }
        answer = sale;

        int margin;
        int front = 0, rear = m;
        while (rear < n) {
            margin = input[rear] - input[front];
            if ((sale + margin) > answer) {
                answer = sale + margin;
            }
            sale = sale + margin;
            front++;
            rear++;
        }

        return answer;
    }
}
