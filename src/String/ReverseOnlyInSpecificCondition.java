package String;

import java.util.Scanner;

public class ReverseOnlyInSpecificCondition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(ReverseOnlyInSpecificCondition.solution(input));
    }

    public static String solution(String input) {
        String answer = "";
        char[] charArray = input.toCharArray();
        int front = 0;
        int rear = charArray.length - 1;

        while (front < rear) {
            if (!Character.isAlphabetic(charArray[front])) {
                front++;
            } else if (!Character.isAlphabetic(charArray[rear])) {
                rear--;
            } else {
                char temp = charArray[front];
                charArray[front] = charArray[rear];
                charArray[rear] = temp;
                front++;
                rear--;
            }
        }
        answer = String.valueOf(charArray);

        return answer;
    }
}
