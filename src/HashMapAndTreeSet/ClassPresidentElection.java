package HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresidentElection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String input = scanner.next();
        System.out.println(ClassPresidentElection.solution(n, input));
    }

    private static char solution(int n, String input) {
        char answer = ' ';

        char[] keys = {'A', 'B', 'C', 'D', 'E'};
        HashMap<Character, Integer> votes = new HashMap<>();
        for (int i=0; i<5; i++) {
            votes.put(keys[i], 0);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<5; j++) {
                if (input.charAt(i) == keys[j]) {
                    votes.replace(keys[j], votes.get(keys[j]) + 1);
                }
            }
        }

        int count = 0;
        int temp;
        for (int i=0; i<5; i++) {
            temp = votes.get(keys[i]);
            if (temp > count) {
                count = temp;
                answer = keys[i];
            }
        }

        return answer;
    }
}
