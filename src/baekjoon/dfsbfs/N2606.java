package baekjoon.dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

// 바이러스
public class N2606 {

    class
    static int answer;

    public static void dfs(){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computers = sc.nextInt();
        int connectCnt = sc.nextInt();

        ArrayList<int[]> connectedList = new ArrayList<>(connectCnt);

        for(int i=0; i<connectCnt ; i++){
            int[] connected = {sc.nextInt(), sc.nextInt()};
            connectedList.add(connected);
        }

        dfs();


        System.out.println(answer);

    }
}
