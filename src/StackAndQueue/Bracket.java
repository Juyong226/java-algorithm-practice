package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Bracket.solution(input));
    }

    public static String solution(String input) {
        String answer = "NO";
        int sum = 0;
        char[] brackets = input.toCharArray();
        int i = 0;
        while (i < brackets.length) {
            if (sum < 0) break;
            if (brackets[i] == '(') {
                sum++;
            } else {
                sum--;
            }
            i++;
        }
        if (sum == 0) answer = "YES";
        return answer;
    }

    public static String solution2(String input) {
        String answer = "YES";

        Stack<Character> stack = new Stack<>();
        for (char x : input.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }
}
