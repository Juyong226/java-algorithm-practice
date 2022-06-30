package Array;

import java.util.Scanner;

public class TemporaryClassPresident {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[n][5];
        for (int i=0; i<n; i++) {
            for (int j=0; j<5; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        System.out.println(TemporaryClassPresident.solution(n, input));
    }

    private static int solution(int n, int[][] input) {
        int answer = 0;

        /**
         * 내 방식은 기준 학생을 i, 학년을 j, 다른 학생을 k for 문과 연관지여 로직을 구성함
         * 이 방식대로 하면 2번 이상 같은 반이 된 경우를 걸러내가가 어려움
         * */
//        int[] di = {1, 2, 3, 4};
//        int max = Integer.MIN_VALUE;
//        int count;
//        int temp;
//        for (int i=0; i<n; i++) {
//            count = 0;
//            for (int j=0; j<n; j++) {
//                temp = input[i][j];
//                for (int k=0; k<4; k++) {
//                    int adj_i = (i + di[k]) % 5;
//                    if (temp == input[adj_i][j]) {
//                        count++;
//                    }
//                }
//            }
//            if (count > max) {
//                max = count;
//                answer = i + 1;
//            }
//        }

        /**
         * 이 방식은 기준 학생을 i, 다른 학생을 j, 학년을 k로 두고 for 문을 돌림
         * 이렇게 하면 j for를 돌다가 해당 학생과 같은 반이 된 적이 있으면 break를 통해 j for문을 빠져나옴으로써 중복을 방지할 수 있다.
         * */
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                for (int k=0; k<5; k++) {
                    if (input[i][k] == input[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i + 1;
            }
        }

        return answer;
    }
}
