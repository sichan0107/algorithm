package baekjoon;

import java.util.Scanner;

// 재귀함수가 뭔가요?
public class N17478 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static int input = 0;
    static String sep = "----";



    public static void solution(int count){


        StringBuilder tempSep = new StringBuilder();
        for(int i=0; i<count; i++){
            tempSep.append(sep);
        }

        sb.append(tempSep.toString());
        sb.append("재귀함수가 뭔가요?\n");
        sb.append(tempSep.toString());
        sb.append("잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(tempSep.toString());
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(tempSep.toString());
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\n");
        //System.out.println(sb.toString());

        count = count + 1;

        if( count < input ){
            solution(count);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input  = sc.nextInt();

        //count = input;

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        solution(count);



        System.out.println(sb.toString());
    }
}