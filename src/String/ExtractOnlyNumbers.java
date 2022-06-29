package String;

import java.util.Scanner;

public class ExtractOnlyNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(ExtractOnlyNumbers.solution(input));
    }

    public static int solution(String input) {
        int answer = 0;

        /**
         * 아스키 넘버를 활용하여 해결
         * */
//        for (char x : input.toCharArray()) {
//            if (x >= 48 && x <= 57) { // 아스키 넘버 48~57은 숫자 0~9
//                // 숫자를 순서대로 나열하는 식
//                // x는 char 이기 때문에 int 형으로 바꾸려면 48을 빼야함
//                answer = answer * 10 + (x - 48);
//            }
//        }

        /**
         * Character.isDigit(char)를 활용하여 해결
         * */
//        String temp = "";
//        for (char x : input.toCharArray()) {
//            if (Character.isDigit(x)) {
//                temp += x;
//            }
//        }
//        answer = Integer.parseInt(temp);

        /**
         * String.replaceAll(regex, replacement)를 활용하여 해결
         * 문자열에서 숫자를 제외한 모든 문자를 제거 후 그 값을 int로 변환
         * (Integer.parseInt(String) 하면 맨 앞이 0인 경우 자동으로 제거한다.)
         * */
        input = input.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(input);

        return answer;
    }
}
