package codingtest.Week5;

import java.util.Scanner;
import java.util.Stack;

public class mz_17608 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //

        Stack<Integer> stackBar = new Stack<>();

        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            int num = sc.nextInt();
            stackBar.push(num);
        }

        int stackTop = stackBar.pop();
        int barNum = 1;

        while(!stackBar.isEmpty()) {
            int b = stackBar.pop();

            if(b>stackTop){
                stackTop = b;
                barNum++;
            }
        }

        System.out.println(barNum);

    }

}
