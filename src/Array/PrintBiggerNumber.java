package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintBiggerNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        for (int x : PrintBiggerNumber.solution(input)) {
            System.out.print(x + " ");
        }
    }

    public static ArrayList<Integer> solution(int[] input) {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean isFirst = true;
        for (int i=0; i<input.length; i++) {
            if (isFirst) {
                answer.add(input[i]);
                isFirst = false;
            } else {
                if (input[i] > input[i-1]) {
                    answer.add(input[i]);
                }
            }
        }

//        answer.add(input[0]);
//        for (int i=1; i<input.length; i++) {
//            if (input[i] > input[i-1]) {
//                answer.add(input[i]);
//            }
//        }

        return answer;
    }
}
