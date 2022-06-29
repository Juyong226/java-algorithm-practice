package String;

import java.util.Scanner;

public class Decode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String input = scanner.next();
        System.out.println(Decode.solution(input, count));
    }

    public static String solution(String input, int count) {
        String answer = "";

//        for (int i=0; i<count; i++) {
//            String temp = "";
//            for (int j=i*7; j<i*7+7; j++) {
//                if (input.charAt(j) == '#') temp += 1;
//                else temp += 0;
//            }
//
//            int letter = 0;
//            int k = 0;
//            for (int j=temp.length()-1; j>=0; j--) {
//                letter += Math.pow(2, k) * (temp.charAt(j) - 48);
//                k++;
//            }
//            answer += (char) letter;
//        }

        for (int i=0; i<count; i++) {
            // 문자열에서 문자의 변환 -> replace() 사용!
            String temp = input.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(temp, 2);
            answer += (char) num;
            input = input.substring(7);
        }

        return answer;
    }
}
