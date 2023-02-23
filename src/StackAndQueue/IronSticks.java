package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class IronSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        System.out.println(IronSticks.solution(brackets));
    }

    private static int solution(String brackets) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<brackets.length(); i++) {
            if (brackets.charAt(i) == '(')
                stack.push('(');
            else {
                stack.pop();
                if (brackets.charAt(i-1) == '(')
                    answer += stack.size();
                else
                    answer += 1;
            }
        }

        return answer;
    }
}
