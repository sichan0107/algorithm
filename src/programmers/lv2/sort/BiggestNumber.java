package programmers.lv2.sort;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 가장 큰 수
public class BiggestNumber {
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        List<Integer> numList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = -1;
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                String standard = (s1.length() >= s2.length()) ? s2 : s1; // s1이 더크면 s2의 길이만큼 비교한다.

                // 1. 두 문자열의 첫번째 글자 비교
                for(int i=0 ; i<standard.length(); i++){
                    int sFirst = Integer.parseInt(String.valueOf(s1.charAt(i)));
                    int sSecond = Integer.parseInt(String.valueOf(s2.charAt(i)));

                    if(sSecond > sFirst){
                        return 1; // 뒤 숫자의 첫번째 원소가 클 경우 위치 교환
                    }else if(sSecond == sFirst){
                        // 숫자가 같을 경우
                        String reCompare = (s1.length() > s2.length()) ? "s1" : "s2";

                        if(reCompare.equals("s2")){
                           result = sFirst > Integer.parseInt(String.valueOf(s2.charAt(i+1))) ? -1 : 1;
                        }else{
                            result = sSecond > Integer.parseInt(String.valueOf(s1.charAt(i+1))) ? 1 : -1;
                        }

                    }else{
                        continue;
                    }

                }

                return result;
            }
        };

        Collections.sort(numList, comparator);

        for(int i : numList){
            sb.append(String.valueOf(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        //int[] numbers = {6, 10, 2}; // 6210
        int[] numbers = {3, 30, 34, 5, 9}; // 9534330
                                            //9534303 내꺼

        // 3 39
        // 9534 339
        // 9534 393

        // 3 32
        // 9534 332
        // 9534 323

        System.out.println(solution(numbers));

    }

}
