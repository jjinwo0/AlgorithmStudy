package codingtest.Week6;

import java.util.Scanner;
import java.util.Stack;

public class S4_10773 {
    public static void main(String[] args) {
        Stack<Integer>  stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        int K = sc.nextInt();

        for(int i=0; i<K; i++) {
            int n = sc.nextInt();
                if(n == 0) {
                    stack.pop();
                }else
                    stack.push(n);
        }

        while(!stack.isEmpty()) {
            int a = stack.pop();
            sum += a;
        }

        System.out.println(sum);


    }
}
