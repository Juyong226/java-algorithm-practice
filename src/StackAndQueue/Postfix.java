package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pf = scanner.nextLine();
        System.out.println(Postfix.solution(pf));
    }

    private static int solution(String pf) {
        int answer;

        Stack<Integer> stack = new Stack<>();
        int front, rear, result;
        for (char item : pf.toCharArray()) {
            if (Character.isDigit(item)) {
                stack.push(item-48);
            } else {
                rear = stack.pop();
                front = stack.pop();
                if (item == '+') result = front+rear;
                else if (item == '-') result = front-rear;
                else if (item == '*') result = front*rear;
                else result = front/rear;
                stack.push(result);
            }
        }
        answer = stack.pop();
        return answer;
    }
}
