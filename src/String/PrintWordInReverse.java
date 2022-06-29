package String;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintWordInReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i=0; i<n; i++) {
            words[i] = scanner.next();
        }
        for (String x : PrintWordInReverse.solution(n, words)) {
            System.out.println(x);
        }
    }

    /**
     * 입력 받은 단어 배열에서, 각 단어의 알파벳 순서를 뒤집은 리스트를 생성하여 반환
     * */
    public static ArrayList<String> solution(int n, String[] words) {
        ArrayList<String> answer = new ArrayList<>();

        /**
         * StringBuilder를 활용하여 해결
         * StringBuilder.reverse(): StringBuilder의 문자열의 순서를 거꾸로 바꿈
         * */
//        for (String word : words) {
//            StringBuilder builder = new StringBuilder(word);
//            String temp = builder.reverse().toString();
//            answer.add(temp);
//        }

        /**
         * 문자열을 문자 배열로 변환하여 직접 문자의 순서를 거꾸로 바꿈
         * 문자 배열의 맨 앞 인덱스(front)와 맨 뒤 인덱스(rear)의 자리를 바꿔줌으로써 구현
         * 자리를 바꿔줄 때마다 front는 1 증가, rear는 1 감소
         * front < rear 일 때만 수행, front == rear 또는 front > rear 이면 멈춤
         * */
        for (String word : words) {
            char[] charArray = word.toCharArray();
            int front = 0;
            int rear = charArray.length - 1;
            while (front <  rear) {
                char temp = charArray[front];
                charArray[front] = charArray[rear];
                charArray[rear] = temp;
                front++;
                rear--;
            }
            String temp = String.valueOf(charArray);
            answer.add(temp);
        }

        return answer;
    }
}
