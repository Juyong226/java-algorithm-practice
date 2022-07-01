package TwoPointersAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindCommons {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i=0; i<m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int x : FindCommons.solution(n, a, m, b)) {
            System.out.print(x + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int[] a, int m, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);
        int pa = 0, pb = 0;
        while (pa < n && pb < m) {
            if (a[pa] == b[pb]) {
                answer.add(a[pa++]);
                pb++;
            }
            else if (a[pa] < b[pb]) pa++;
            else pb++;
        }

        return answer;
    }
}
