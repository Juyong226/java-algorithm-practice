package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Crane {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] array = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        List<Stack<Integer>> board = new ArrayList<>();
        Stack<Integer> temp;
        for (int j=0; j<n; j++) {
            temp = new Stack<>();
            for (int i=n-1; i>=0; i--) {
                if (array[i][j] != 0) temp.push(array[i][j]);
            }
            board.add(temp);
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i=0; i<m; i++) {
            moves[i] = scanner.nextInt();
        }

        System.out.println(Crane.solution(board, moves));
    }

    private static int solution(List<Stack<Integer>> board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();
        Stack<Integer> temp;
        int doll;
        for (int idx : moves) {
            temp = board.get(idx-1);
            if (!temp.isEmpty()) {
                doll = temp.pop();
                if (!basket.isEmpty() && (basket.peek() == doll)) {
                    basket.pop();
                    answer++;
                } else basket.push(doll);
            }
        }

        return (answer * 2);
    }
}
