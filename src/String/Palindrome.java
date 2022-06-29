package String;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(Palindrome.solution(input));
    }

    public static String solution(String input) {
        String answer = "YES";

        /**
         * for 문을 직접 이용하여 문자열의 front와 rear 인덱스를 직접 비교하는 방식으로 해결
         * */
//        input = input.toUpperCase();
//        int length = input.length();
//
//        for (int i=0; i<length/2; i++) {
//            if (input.charAt(i) != input.charAt(length -i -1)) {
//                return "NO";
//            }
//        }

        input = input.toUpperCase();
        char[] charArray = input.toCharArray();
        int front = 0;
        int rear = charArray.length -1;
        while (front < rear) {
            if (charArray[front] != charArray[rear]) return "NO";
            else {
                front++;
                rear--;
            }
        }

        /**
         * StringBuilder.reverse()를 활용하여 해결
         * 문자열을 뒤집기 전과 뒤집은 후가 같은지 equalsIgnoreCase()를 통해 확인
         * */
//        StringBuilder sb = new StringBuilder(input);
//        String input_reverse = sb.reverse().toString();
//        if (!input.equalsIgnoreCase(input_reverse)) answer = "NO";

        return answer;
    }
}
