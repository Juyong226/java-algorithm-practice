package TwoPointersAndSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input_a = new int[n];
        for (int i=0; i<n; i++) {
            input_a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] input_b = new int[m];
        for (int i=0; i<m; i++) {
            input_b[i] = scanner.nextInt();
        }
        for (int x : MergeArrays.solution(n, input_a, m, input_b)) {
            System.out.print(x + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int[] input_a, int m, int[] input_b) {
        ArrayList<Integer> answer = new ArrayList<>();

//        int min;
//        int min_a = Integer.MAX_VALUE;
//        int min_b = Integer.MAX_VALUE;
//        for (int i=0; i<n+m; i++) {
//            for (int j=0; j<n; j++) {
//                if (input_a[j] < min_a) {
//                    min_a = input_a[j];
//                    input_a[j] = Integer.MAX_VALUE;
//                }
//            }
//
//            for (int j=0; j<m; j++) {
//                if (input_b[j] < min_b) {
//                    min_b = input_b[j];
//                    input_b[j] = Integer.MAX_VALUE;
//                }
//            }
//
//            if (min_a >= min_b) {
//                min = min_b;
//                min_b = Integer.MAX_VALUE;
//            }
//            else {
//                min = min_a;
//                min_a = Integer.MAX_VALUE;
//            }
//
//            answer.add(min);
//        }

        /**
         * Two Pointers
         * */
        int p_a = 0;
        int p_b = 0;
        while (p_a < n && p_b < m) {
            if (input_a[p_a] <= input_b[p_b]) {
                answer.add(input_a[p_a]);
                p_a++;
            } else {
                answer.add(input_b[p_b]);
                p_b++;
            }
        }
        if (p_a < n) {
            for (int i=p_a; i<n; i++) {
                answer.add((input_a[i]));
            }
        }
        if (p_b < m) {
            for (int i=p_b; i<m; i++) {
                answer.add((input_b[i]));
            }
        }

        return answer;
    }
}
