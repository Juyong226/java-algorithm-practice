package String;

import java.util.Scanner;

public class Palindrome2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Palindrome2.solution(input));
    }

    public static String solution(String input) {
        String answer = "YES";

        /**
         * 문자열에서 특정 문자에 대한 팰린드롬 검사를 요구하는 경우
         * String.replaceAll(regex, replacement)를 활용하여 비교할 필요가 없는 문자를 제거한 후 해결
         * 매개변수 regex에 정규식을 넘겨줄 수 있다. (정규식 만드는 법을 찾아보자)
         * */
        input = input.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder sb = new StringBuilder(input);
        String input_reverse = sb.reverse().toString();
        if (!input.equals(input_reverse)) return "NO";

        return answer;
    }
}
