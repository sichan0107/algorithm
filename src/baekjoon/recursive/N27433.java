package baekjoon.recursive;

import java.util.Scanner;

// 팩토리얼
public class N27433 {

    static long result = 1;
    public static void factorial(long nLong){
        if(nLong < 2){
            return;
        }

        result = result * nLong;

        factorial(nLong - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        factorial(sc.nextInt());
        System.out.println(result);
    }
}
