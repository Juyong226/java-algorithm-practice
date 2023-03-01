package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prince {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
        }
        System.out.println(Prince.solution(queue, k));
    }

    private static int solution(Queue<Integer> queue, int k) {
        int answer;

        int temp;
        while (queue.size() > 1) {
            for (int i=1; i<k; i++)  {
                temp = queue.peek();
                queue.remove();
                queue.add(temp);
            }
            queue.remove();
        }
        answer = queue.peek();

        return answer;
    }
}
