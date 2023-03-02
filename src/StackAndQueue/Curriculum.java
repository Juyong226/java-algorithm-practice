package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String required = scanner.nextLine();
        String plan = scanner.nextLine();
        System.out.println(Curriculum.solution(required, plan));
    }

    private static String solution(String required, String plan) {
        Queue<Character> reqQ = new LinkedList<>();
        Queue<Character> planQ = new LinkedList<>();

        for (char x : required.toCharArray()) {
            reqQ.offer(x);
        }
        for (char x : plan.toCharArray()) {
            planQ.offer(x);
        }

        char temp;
        while(planQ.size() > 0) {
            temp = planQ.poll();
            if (!reqQ.isEmpty()) {
                if (temp == reqQ.peek()) reqQ.poll();
            }
        }

        return reqQ.isEmpty() ? "YES" : "NO";
    }
}
