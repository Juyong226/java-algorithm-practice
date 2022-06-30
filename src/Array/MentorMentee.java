package Array;

import java.util.Scanner;

public class MentorMentee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] input = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        System.out.println(MentorMentee.solution(n, m, input));
    }

    private static int solution(int n, int m, int[][] input) {
        int answer = 0;

        /**
         * i 학생, j 학생 (i,j : 1~n)
         * m번 시험, n등
         * */
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                boolean isMatched = true;
                for (int k=0; k<m; k++) {
                    int ir = 0;
                    int jr = 0;
                    for (int r=0; r<n; r++) {
                        if (input[k][r] == i) ir = r;
                        if (input[k][r] == j) jr = r;
                    }
                    if (ir >= jr) {
                        isMatched = false;
                        break;
                    }
                }
                if (isMatched) answer++;
            }
        }

        return answer;
    }
}
