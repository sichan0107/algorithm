package programmers.lv2.stack;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  LV2 기능 개발
 */
public class FunctionDevelop {

        /**
         * 1. Array -> List로 변환하는 두 가지 방법
         *
         * (1) Arrays.asList( array ) : Wrapper 클래스만 지원함. primitive type은 stream을 이용한다.
         *
         * (2) Arrays.stream( array ).boxed().collect(Collectors.toList())
         *
         * =======================================================================================
         *
         * 2. List -> Array로 변환하는 두 가지 방법
         *
         * (1) Integer[] arr = list.toArray(Integer[]::new) : List 객체의 toArray를 쓰고 파라미터로 변경할 배열의 생성자를 넣는다.
         *
         * (2) List를 Primitive 배열로 변환
         *
         *   int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();
         */

    // solution2는 배열만으로 풀어보려 했으나.... 메모리 초과 발생...
    public static int[] solution2(int[] progresses, int[] speeds){
        ArrayList<Integer> resultList = new ArrayList<>();
        int resultIdx = 0;
        int idx = 0;

        while(idx < progresses.length){
            int firstProgress = progresses[idx];
            int firstSpeed = speeds[idx];
            int remainDays = (100 - firstProgress) / firstSpeed;

            for(int i = idx; i<progresses.length ; i++){
                progresses[i] = progresses[i] + (speeds[i] * remainDays);
            }

            int cnt = 0;
            for(int i = idx ; i<progresses.length ; i++){
                if(progresses[i] >= 100){
                    cnt++;
                    idx++;
                }
                else{
                    break;
                }
            }
            resultList.add(cnt);
            resultIdx++;
        }

        int[] result = new int[resultList.size()];
        for(int i=0; i<result.length ; i++){
            result[i] = resultList.get(i);
        }

        //return resultList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> completeDays = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i]; //99, 96, 94
            double dDay = Double.parseDouble(String.valueOf(remain)) / Double.parseDouble(String.valueOf(speeds[i]));
            int day = (int)Math.ceil(dDay) ; //1, 3, 4

            completeDays.add(day);
        }

        while (!completeDays.isEmpty()){
            int day = completeDays.poll();
            int cnt = 1;

            while(!completeDays.isEmpty() && day >= completeDays.peek()){
                completeDays.poll();
                cnt++;
            }
            resultList.add(cnt);
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        //System.out.println((100 - 93) / 1);

        /**
         *  Test case 11의 반례
         *  progresses = 99, 96, 94
         *  speeds = 1, 3, 4
         *  기대값 : 1, 2
         */

        int[] progresses = {99, 96, 94};
        int[] speeds = {1, 3, 4};

        //int[] progresses = {95, 90, 99, 99, 80, 99};
        //int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = solution(progresses, speeds);
        for(int i : result){
            System.out.println(i);
        }

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");

    }

}
