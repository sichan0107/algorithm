package programmers.lv2.bruteforce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// 카펫
public class Carpet {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int size = brown + yellow;

        List<Integer> divisor = divisor(size);

        for(int i=0; i < divisor.size() ; i++){
            int height = divisor.get(i);
            if(height < 3){
                continue;
            }

            int width = divisor.get(divisor.size() - (i+1));

            if(yellow == (width - 2) * (height -2)){
                answer[0] = width;
                answer[1] = height;
                break;

            }

        }

        return answer;
    }


    public static List<Integer> divisor(int num) {
        List<Integer> resultList = new ArrayList<>();
        IntStream.rangeClosed(1, num)
                .filter(i -> num % i == 0)
                .filter(i -> i != 1 && i != num)
                .forEach(resultList::add);

        return resultList;
    }

    public static void main(String[] args) throws IOException {

        int brown = 10;
        int yellow = 2;

        int[] result = solution(24, 24);

//        for(int i : result){
//            System.out.println(i);
//
//        }

    }

}
