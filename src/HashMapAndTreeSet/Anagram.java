package HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str_1 = scanner.next();
        String str_2 = scanner.next();
        System.out.println(Anagram.solution(str_1, str_2));
    }

    private static String solution(String str_1, String str_2) {
        String answer = "NO";
        if (str_1.length() == str_2.length()) {
            HashMap<Character, Integer> map_1 = new HashMap<>();
            HashMap<Character, Integer> map_2 = new HashMap<>();
            char temp_1;
            char temp_2;
            for (int i = 0; i < str_1.length(); i++) {
                temp_1 = str_1.charAt(i);
                if (map_1.containsKey(temp_1)) {
                    map_1.replace(temp_1, map_1.get(temp_1) + 1);
                } else map_1.put(temp_1, 1);

                temp_2 = str_2.charAt(i);
                if (map_2.containsKey(temp_2)) {
                    map_2.replace(temp_2, map_2.get(temp_2) + 1);
                } else map_2.put(temp_2, 1);
            }

            if (map_1.equals(map_2)) answer = "YES";
        }
        return answer;
    }
}
