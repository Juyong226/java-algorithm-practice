package HashMapAndTreeSet;

import java.util.*;

public class TheKrdBiggestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(TheKrdBiggestNumber.solution2(n, k, input));
    }

    private static int solution(int n, int k, int[] input) {
        int answer = 0;

        Arrays.sort(input);
        HashMap<Integer, Integer> result = new HashMap<>();
        int front, middle, rear;
        int mp, rp;
        int sum;
        for (int fp=n-1; fp>=2; fp--) {
            front = input[fp];
            mp = fp - 1;
            rp = mp - 1;
            while (mp >= 1) {
                if (rp < 0) {
                    mp--;
                    if (mp < 1) break;
                    rp = mp - 1;
                }
                middle = input[mp];
                rear = input[rp];
                sum = front + middle + rear;
                if (result.containsKey(sum)) result.replace(sum, result.get(sum) + 1);
                else result.put(sum, 1);
                rp--;
            }
        }

        Object[] keys = result.keySet().toArray();
        Arrays.sort(keys);
        if (keys.length < k) answer = -1;
        else answer = (int) keys[keys.length - k];

        return answer;
    }

    private static int solution2 (int n, int k, int[] input) {
        int answer = 0;

        HashMap<Integer, Integer> sum = new HashMap<Integer, Integer>();

        int rp = 1;
        int i, ts;
        for (int lp=0; lp<input.length-2; lp++) {
            rp = lp + 1;
            i = rp + 1;
            while (rp < input.length-1) {
                ts = input[lp] + input[rp] + input[i];
                sum.put(ts, sum.getOrDefault(ts, 0) + 1);
                i++;
                if (i > input.length-1) {
                    rp++;
                    i = rp + 1;
                }
            }
        }

        Object[] keys = sum.keySet().toArray();
        Arrays.sort(keys);
        if (keys.length < k) answer = -1;
        else answer = (int)keys[keys.length-k];

        return answer;
    }
}
