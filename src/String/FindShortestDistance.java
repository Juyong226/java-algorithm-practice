package String;

import java.util.Scanner;

public class FindShortestDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char target = scanner.next().charAt(0);
//        String answer = FindShortestDistance.solution(input, target);
//        for (char x : answer.toCharArray()) {
//            System.out.print(x + " ");
//        }

        for (int x : FindShortestDistance.solution(input, target)) {
            System.out.print(x + " ");
        }
    }

//    public static String solution(String input, char target) {
//        String answer = "";
//
//        int f_distance;
//        int r_distance;
//        String f_input;
//        String r_input;
//        for (int i=0; i<input.length(); i++) {
//            f_input = input.substring(0, i + 1);
//            StringBuilder f_sb = new StringBuilder(f_input);
//            String f_reverse = f_sb.reverse().toString();
//            f_distance = f_reverse.indexOf(target);
//
//            r_input = input.substring(i);
//            r_distance = r_input.indexOf(target);
//
//            if (f_distance == -1) answer += r_distance;
//            else if (r_distance == -1) answer += f_distance;
//            else if (f_distance >= r_distance) answer += r_distance;
//            else answer+= f_distance;
//        }
//
//        return answer;
//    }

    public static int[] solution(String input, char target) {
        int[] answer = new int[input.length()];

        /**
         * 문자열에서 for문을 돌며 문자 앞쪽과 뒤쪽을 동시에 고려해야 하는 경우
         * for문을 순서대로 1번, 역순으로 1번 총 2번 돌리는 것을 고려해보자.
         * */
        int p = 1000;
        int length = input.length();
        for (int i=0; i<length; i++) {
            if (input.charAt(i) == target) p = 0;
            else p++;
            answer[i] = p;
        }

        p = 1000;
        for (int i=(length - 1); i>=0; i--) {
            if (input.charAt(i) == target) p = 0;
            else {
                p++;
                if (answer[i] > p) answer[i] = p;
            }

        }

        return answer;
    }

}
