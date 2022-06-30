package Array;

import java.util.Scanner;

public class NByN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        System.out.println(NByN.solution(n, input));
    }

    public static int solution(int n, int[][] input) {
        int answer = Integer.MIN_VALUE;

        int sum1;
        int sum2;
        for (int i=0; i<n; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j=0; j<n; j++) {
                sum1 += input[i][j];
                sum2 += input[j][i];
            }
            if (sum1 > answer) answer = sum1;
            if (sum2 > answer) answer = sum2;
        }

        sum1 = 0;
        sum2 = 0;
        for (int i=0; i<n; i++) {
            sum1 += input[i][i];
            sum2 += input[i][n - 1 - i];
        }
        if (sum1 > answer) answer = sum1;
        if (sum2 > answer) answer = sum2;

        return answer;
    }
}
