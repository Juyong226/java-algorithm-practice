package HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class CountAllAnagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pool = scanner.next();
        String target = scanner.next();
        System.out.println(CountAllAnagram.solution2(pool, target));
    }

    private static int solution(String pool, String target) {
        int answer = 0;

        HashMap<Character, Integer> original = new HashMap<>();
        HashMap<Character, Integer> temp_map = new HashMap<>();

        char temp;
        for (int i=0; i<target.length(); i++) {
            temp = target.charAt(i);
            if (original.containsKey(temp)) original.replace(temp, original.get(temp) + 1);
            else original.put(temp, 1);

            temp = pool.charAt(i);
            if (temp_map.containsKey(temp)) temp_map.replace(temp, temp_map.get(temp) + 1);
            else temp_map.put(temp, 1);
        }

        int lp = 0;
        char left, right;
        for (int rp=target.length(); rp<pool.length(); rp++) {
            if (original.equals(temp_map)) answer++;
            left = pool.charAt(lp);
            right = pool.charAt(rp);
            if (temp_map.containsKey(left)) {
                if ((temp_map.get(left) - 1) == 0) temp_map.remove(left);
                else temp_map.replace(left, temp_map.get(left) - 1);
            }
            if (temp_map.containsKey(right)) temp_map.replace(right, temp_map.get(right) + 1);
            else temp_map.put(right, 1);
            lp++;
        }
        if (original.equals(temp_map)) answer++;

        return answer;
    }

    private static int solution2(String pool, String target) {
        int answer = 0;

        HashMap<Character, Integer> tempMap = new HashMap<>();
        HashMap<Character, Integer> targetMap = new HashMap<>();

        for (int i=0; i<target.length(); i++) {
            char temp = target.charAt(i);
            targetMap.put(temp, targetMap.getOrDefault(temp, 0) + 1);
        }

        int lp = 0;
        char temp;
        for (int rp=0; rp<pool.length(); rp++) {
            while (rp < target.length()) {
                temp = pool.charAt(rp);
                tempMap.put(temp, tempMap.getOrDefault(temp, 0) + 1);
                if (rp == target.length() -1) {
                    if (targetMap.equals(tempMap)) answer++;
                }
                rp++;
            }
            temp = pool.charAt(rp);
            tempMap.put(temp, tempMap.getOrDefault(temp, 0) + 1);
            temp = pool.charAt(lp++);
            tempMap.put(temp, tempMap.get(temp) - 1);
            if (tempMap.get(temp) == 0) tempMap.remove(temp);
            if (targetMap.equals(tempMap)) answer++;
        }
        return answer;
    }
}
