package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversedPrimeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            int temp = scanner.nextInt();
            String reversed_num = new StringBuilder(String.valueOf(temp))
                                    .reverse()
                                    .toString();
            input[i] = Integer.parseInt(reversed_num);
        }
        for (int x : ReversedPrimeNumbers.solution(input)) {
            System.out.print(x + " ");
        }
    }

    public static ArrayList<Integer> solution(int[] input) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i=0; i<input.length; i++) {
            int temp = input[i];
            Boolean isPrimeNumber = true;
            for (int j=2; j<temp; j++) {
                if (temp % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (temp != 1 && isPrimeNumber) answer.add(temp);
        }

        return answer;
    }
}
