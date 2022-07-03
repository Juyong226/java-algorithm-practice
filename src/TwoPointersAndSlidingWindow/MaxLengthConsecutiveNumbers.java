package TwoPointersAndSlidingWindow;

import java.util.Scanner;

public class MaxLengthConsecutiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(MaxLengthConsecutiveNumbers.solution(n, k, input));
    }

    private static int solution(int n, int k, int[] input) {
        int answer = 0;

        int length = Integer.MIN_VALUE;
        int zeros = 0, lp = 0;
        int temp;
        for (int rp=0; rp<input.length; rp++) {
            if (zeros <= k) {
                temp = input[rp];
                if (temp == 0) {
                    zeros++;
                    if (zeros > k) {
                        if ((rp - lp) > length) length = (rp - lp);
                    };
                }
            }
            while (zeros > k) {
                temp = input[lp];
                if (temp == 0) {
                    lp++;
                    zeros--;
                } else lp++;
            }
        }
        answer = length;

        return answer;
    }
}
