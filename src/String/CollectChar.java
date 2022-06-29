package String;

import java.util.Scanner;

public class CollectChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(CollectChar.solution(input));
    }

    public static String solution(String input) {
        String answer = "";

//        char char_before = ' ';
//        int count = 0;
//        for (int i=0; i<input.length(); i++) {
//            char temp = input.charAt(i);
//
//            if (temp == char_before) {
//                count++;
//            } else {
//                if (count > 1) answer += count;
//                count = 1;
//            }
//
//            if (count == 1) {
//                answer += temp;
//            }
//            char_before = temp;
//        }
//
//        if (count > 1) answer += count;

        input += " ";
        int count = 1;
        for (int i=0; i<input.length()-1; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                count++;
            } else {
                answer += input.charAt(i);
                if (count > 1)  answer += count;
                count = 1;
            }
        }

        return answer;
    }
}
