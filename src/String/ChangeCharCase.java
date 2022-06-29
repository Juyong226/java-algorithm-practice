package String;

import java.util.Scanner;

public class ChangeCharCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(ChangeCharCase.solution(input));
    }

    public static String solution(String input) {
        String answer = "";

        /**
         * 대소문자 변경을 자바 Character 클래스의 메서드를 활용하여 푸는 방법
         * */
//        for (char x : input.toCharArray()) {
//            if (Character.isLowerCase(x)) {
//                answer += Character.toUpperCase(x);
//            } else {
//                answer += Character.toLowerCase(x);
//            }
//        }

        /**
         * 대소문자 변경을 아스키 코드를 활용해서 푸는 방법
         * 대문자 아스키 코드 : 65 ~ 90
         * 소문자 아스키 코드 : 97 ~ 122
         * -> 소문자에서 32를 빼면 대문자로 바뀜
         * */
        for (char x : input.toCharArray()) {
            if (x >= 97 && x <= 122) {
                answer += (char) (x - 32);
            } else {
                answer += (char) (x + 32);
            }
        }

        return answer;
    }
}
