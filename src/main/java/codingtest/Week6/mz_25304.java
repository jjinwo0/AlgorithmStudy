package codingtest.Week6;

import java.util.Scanner;

public class mz_25304 {
    public static void main(String[] args) {
        int money;
        int things;
        int sum = 0;

        Scanner sc = new Scanner(System.in);

        money = sc.nextInt();
        sc.nextLine();
        things = sc.nextInt();

        for(int i=0; i<things; i++) {
            int price = sc.nextInt();
            int num = sc.nextInt();
            sum += price * num;
        }

        if(money == sum) {
            System.out.println("Yes");
        } else
            System.out.println("No");


    }
}
