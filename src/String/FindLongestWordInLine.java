package String;

import java.util.Scanner;

public class FindLongestWordInLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // 한 단어가 아닌, 한 줄을 입력 받기 위해 nextLine()을 사용
        System.out.println(FindLongestWordInLine.solution(input));
    }

    public static String solution(String input) {
        String answer = "";
        int max = Integer.MIN_VALUE;

        /**
         * String.split(regex)를 활용하여 해결
         * 매개변수에 들어온 regex(문자열)을 기준으로 대상 문자열을 나누어 배열로 반환,
         * 여기선 공백을 기준으로 대상 문자열을 작은 문자열로 구분지어 배열로 변경함
         * */
//        String[] s = input.split(" ");
//        for (String x : s) {
//            int length = x.length();
//            if (length > max) {
//                max = length;
//                answer = x;
//            }
//        }

        /**
         * indexOf(), substring()을 활용하여 해결
         * indexOf(input): input(문자열)과 같은 최초 문자열의 첫 글자 자릿수를 반환, 없으면 -1을 반환
         * substring(start): start(int) 인덱스부터 끝까지의 문자열을 반환
         * substring(start, end): start(int) 인덱스부터 end(int)의 직전 인덱스까지의 문자열을 반환
         * */
        int position;
        while ((position = input.indexOf(" ")) != -1) {
            String temp = input.substring(0, position);
            int length = temp.length();
            if (length > max) {
                max = length;
                answer = temp;
            }
            input = input.substring(position + 1);
        }
        if (input.length() > max) answer = input;
        return answer;
    }
}
