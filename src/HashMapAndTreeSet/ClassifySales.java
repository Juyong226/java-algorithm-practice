package HashMapAndTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ClassifySales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        for (int x : ClassifySales.solution2(n, k, input)) {
            System.out.print(x + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int k, int[] input) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int i=0; i<k; i++) {
            temp = input[i];
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            } else map.put(temp, 1);
        }

        int lp = 0;
        for (int rp=k; rp<n; rp++) {
            answer.add(map.size());
            temp = input[rp];
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            } else map.put(temp, 1);

            temp = input[lp];
            if (map.containsKey(temp)) {
                if (map.get(temp) > 1) map.replace(temp, map.get(temp) - 1);
                else map.remove(temp);
            }
            lp++;
        }
        answer.add(map.size());

        return answer;
    }

    private static int[] solution2(int n, int k, int[] arr) {
        int[] answer = new int[n-k+1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer[0] = map.keySet().size();

        int lp = 0;
        for (int rp=k; rp<n; rp++) {
            map.replace(arr[lp], map.get(arr[lp]) -1);
            if (map.get(arr[lp++]) == 0) map.remove(arr[lp - 1]);

            map.put(arr[rp], map.getOrDefault(arr[rp], 0) + 1);

            answer[lp] = map.keySet().size();
        }
        return answer;
    }
}
