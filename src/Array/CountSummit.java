package Array;

import java.util.Scanner;

public class CountSummit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[n + 2][n + 2];
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        System.out.println(CountSummit.solution(n, input));
    }

    private static int solution(int n, int[][] input) {
        int answer = 0;

//        int temp = 0;
//        for (int i=1; i<n+1; i++) {
//            for (int j=1; j<n+1; j++) {
//                temp = input[i][j];
//                if (temp > input[i-1][j] && temp > input[i+1][j]
//                        && temp > input[i][j-1] && temp > input[i][j+1]) {
//                    answer++;
//                }
//            }
//        }

        /**
         * 봉우리 찾기
         * - 2차원 배열에서 사방 혹은 팔방의 원소들과 값을 비교해야 하는 문제
         * - 위의 내 방식처럼 조건을 많이 넣어 해결할 수도 있지만, 이는 간결하지 못한 코드 (8방향 비교가 필요하면 조건문이 8개)
         * - 따라서 방향 관련 배열을 미리 만들어 놓고, 3중 for 문으로 해결
         * */
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        int temp = 0;
        int adj_i;
        int adj_j;
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                temp = input[i][j];
                boolean flag = true;
                for (int k=0; k<4; k++) {
                    adj_i = i + di[k];
                    adj_j = j + dj[k];
                    if (temp < input[adj_i][adj_j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }
}
