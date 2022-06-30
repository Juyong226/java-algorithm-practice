package Array;

import java.util.Scanner;

public class ScoringStrategy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n + 1];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(ScoringStrategy.solution(input));
    }

    public static int solution(int[] input) {
        int answer = 0;

//        Boolean isConsecutive = false;
//        int extraPoint = 0;
//        for (int i=0; i<input.length; i++) {
//            if (input[i] == 0) {
//                isConsecutive = false;
//                answer += extraPoint;
//                extraPoint = 0;
//            } else {
//                answer++;
//                if (input[i] == input[i+1]) {
//                    isConsecutive = true;
//                    answer += extraPoint;
//                    extraPoint++;
//                } else {
//                    isConsecutive = false;
//                    answer += extraPoint;
//                    extraPoint = 0;
//                }
//            }
//        }

        /**
         * 연속된 (조건)이면 a, 아니면 b 식의 조건
         * 조건이 만족하는 횟수를 count 한다, 조건이 어긋나면 count를 0으로 초기화한다.
         * */
        int count = 0;
        for (int i=0; i<input.length; i++) {
            if (input[i] == 1) {
                count++;
                answer += count;
            } else count = 0;
        }

        return answer;
    }
}
