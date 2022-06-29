package String;

import java.util.Scanner;

public class RemoveDuplicateChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(RemoveDuplicateChar.solution(input));
    }

    public static String solution(String input) {
        String answer = "";

        /**
         * String.indexOf(char)를 활용한 해결
         * indexOf(char): char가 문자열에서 최초로 등장할 때의 인덱스를 반환
         *
         * 문자열-중복 관련 문제를 풀때는 이를 참고하자.
         * */
        for (int i=0; i<input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i) {
                answer += input.charAt(i);
            }
        }
        return answer;
    }
}
