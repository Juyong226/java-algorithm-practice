package Array;

import java.util.Scanner;

public class CountPrimeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(CountPrimeNumbers.solution(n));
    }

    /**
     * 에라토스테네스의 체
     * - n까지의 자연수에서 소수를 걸러내는 알고리즘
     * - 소수는 1과 자기 자신을 제외한 약수가 존재하지 않는 수
     * - 약수가 없다는 것은 반대로 말하면 자신보다 작은 수 중에 자신을 배수로 갖는 수가 없다는 것
     * - for문을 i=2(최초의 소수)부터 n까지 돌면서 i의 배수를 지워나가면서 소수가 아닌 수를 걸러냄
     * - 이 때 걸러진 배수의 원소값을 1로 바꿔주고, count를 늘려줌
     * */
    public static int solution(int n) {
        int answer = 0;

        int[] numbers = new int[n + 1];
        for (int i=2; i<numbers.length; i++) {
            if (numbers[i] == 0) {
                answer++;
                /**
                 * 두번째 for문을 전부 돌면 시간이 오래 걸림
                 * */
//                for (int j=i+1; j<numbers.length; j++) {
//                    if (j % i == 0) {
//                        numbers[j] = 1;
//                    }
//                }

                /**
                 * 두번째 for문에서 i의 배수 인덱스에만 접근해서 값을 변경
                 * j=j+i
                 * */
                for (int j=i; j<numbers.length; j=j+i) {
                    numbers[j] = 1;
                }
            }
        }

        return answer;
    }
}
