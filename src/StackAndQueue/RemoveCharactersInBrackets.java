package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveCharactersInBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(RemoveCharactersInBrackets.solution(input));
    }

    private static String solution(String input) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (char x : input.toCharArray()) {
            if (x == '(') stack.push(x);
            else if (x == ')') stack.pop();
            else {
                if (stack.isEmpty()) sb.append(x);
            }
        }

        return sb.toString();
    }

    private static String solution2(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char temp;
        for (char x : input.toCharArray()) {
            if (x == ')') {
               temp = stack.pop();
               while (temp != '(') {
                   temp = stack.pop();
               }
            } else stack.push(x);
        }
        for (int i=0; i<stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }
}
