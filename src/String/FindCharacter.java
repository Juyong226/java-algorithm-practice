package String;

import java.util.Scanner;

public class FindCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next(); // Scanner의 next()는 다음 문자열을 읽어 들임.
        char targetChar = scanner.next().charAt(0); // next().charAt(index) 다음 문자열 배열에서 해당 인덱스의 문자를 읽어 들임.

        System.out.println(FindCharacter.solution(input, targetChar));
    }

    public static int solution(String input, char targetChar) {
        int answer = 0;

        input = input.toUpperCase();
        targetChar = Character.toUpperCase(targetChar);

//        for (int i=0; i<input.length(); i++) {
//            if (input.charAt(i) == targetChar) {
//                answer++;
//            }
//        }
//        String.toCharArray(): String은 배열이 아니기 때문에 향상된 for에 사용하기 위해 배열로 만들기 위해 사용
        for (char x : input.toCharArray()) {
            if (x == targetChar) {
                answer++;
            }
        }
        return answer;
    }
}
