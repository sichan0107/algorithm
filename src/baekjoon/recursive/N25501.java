package baekjoon.recursive;

import java.util.Scanner;

public class N25501 {

    static int cnt = 0;

    public static int recursion(String s, int l, int r){
        cnt = cnt + 1;
        if(l >= r){
//            if(l > r){
//                System.out.println("s : " + s + " l : " + l + " r : " + r);
//            }
            return 1;
        }
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){

        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inputCnt = sc.nextInt();

        for(int i=0; i<inputCnt ; i++){
            System.out.println(isPalindrome(sc.next()) + " " + cnt);
            cnt = 0;
        }

    }

}
