package Array;

import java.util.Scanner;

public class PrintBiggestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }

        System.out.println(PrintBiggestNumber.solution(input));
    }

    /**
     * 보이는 학생
     * - 학생이 일렬로 서 있을 때 맨 앞에서 보이는 학생의 수를 리턴
     * - 자기 앞에 있는 학생보다 클 경우에만 앞에서 보임
     * -> for문을 돌며 자기 순서 기준으로 자기가 최대값이면 됨 (앞 쪽만 고려)
     * -> 최대값을 갱신하면서 갱신된 횟수를 리턴
     * */
    public static int solution(int[] input) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<input.length; i++) {
            if (input[i] > max) {
                max = input[i];
                max++;
            }
        }

        return max;
    }
}
