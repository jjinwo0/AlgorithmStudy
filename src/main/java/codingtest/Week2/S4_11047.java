package codingtest.Week2;

import java.util.Scanner;

public class S4_11047 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열 크기 입력
        int total = sc.nextInt(); // 구하고자 하는 값 입력
        int[] arr = new int[N]; // 금액을 담는 배열 선언
        int flag = -1;

        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > total)
                flag = i-1;
        }

        if (flag == -1){ // total값이 배열의 마지막 인덱스 값보다 큰 경우,
            calc(N-1, total, arr);
        }else { // total값이 배열의 마지막 인덱스 값보다 작은 경우,
            calc(flag, total, arr);
        }

        System.out.println(answer);
    }

    public static void calc(int N, int total, int[] arr){
        for (int i=N; i>=0; i--){
            int temp = total / arr[i];
            if (temp > 0){
                answer += temp;
                total = total - arr[i] * temp;
            }
        }
    }
}
