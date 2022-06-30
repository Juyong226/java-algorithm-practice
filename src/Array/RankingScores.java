package Array;

import java.util.Scanner;

public class RankingScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        for (int x : RankingScores.solution(input)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int[] input) {
        int[] answer = new int[input.length];

//        int rank = 1;
//        for (int i=0; i<input.length; i++) {
//            int answer = Integer.MIN_VALUE;
//            for (int j=0; j<input.length; j++) {
//                if (input[j] >= answer) {
//                    answer = input[j];
//                }
//            }
//
//            if (answer < 0) break;
//
//            int count = 0;
//            for (int j=0; j<input.length; j++) {
//                if (input[j] == answer) {
//                    input[j] = -1;
//                    count++;
//                    answer[j] = rank;
//                }
//            }
//
//            rank += count;
//        }
        /**
         * 등수의 책정
         * - 내 등수는 내 앞에 몇 명이 있는가에 달려있다.
         * - 중복 for 문을 돌면서 각 원소(i)를 다른 원소들과 비교한다(j)
         * - 값을 비교했을 때 arr[i] < arr[j] 이면 등수를 증가시킨다.
         * */
        for (int i=0; i<input.length; i++) {
            int rank = 1;
            int temp = input[i];
            for (int j=0; j<input.length; j++) {
                if (temp < input[j]) rank++;
            }
            answer[i] = rank;
        }

        return answer;
    }
}
