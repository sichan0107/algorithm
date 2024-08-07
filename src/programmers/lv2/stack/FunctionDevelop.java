package programmers.lv2.stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  LV2 기능 개발
 */
public class FunctionDevelop {

    // 시간초과 됨.
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();

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


        // 반환된 리스트는 고정 사이즈 리스트로 추가, 삭제가 불가능하다
        //List<Integer> progressList = Arrays.asList(progresses);

        // 리스트는 기본 타입(Primitive type)을 지원하지 않기 때문에 boxed()를
        // 이용해 래퍼 타입(Wrapper type) 으로 박싱한 후에 리스트로 변환해야 한다
        List<Integer> progressList = Arrays.stream(progresses).boxed().collect(Collectors.toList());
        List<Integer> speedList = Arrays.stream(speeds).boxed().collect(Collectors.toList());

        while(!progressList.isEmpty()){
            int first = progressList.get(0);
            int remainDays = (100 - first) / speedList.get(0);

            for(int i=0; i<progressList.size(); i++){
                progressList.set(i, progressList.get(i) + (speedList.get(i) * remainDays));
            }

            int cnt = 0;
            while(progressList.get(0) >= 100){
                cnt++;
                progressList.remove(0);
                speedList.remove(0);

                if(progressList.isEmpty()) break;

            }
            answerList.add(cnt);

        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] solution2(int[] progresses, int[] speeds){
        ArrayList<Integer> resultList = new ArrayList<>();
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

        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        //System.out.println((100 - 93) / 1);

        //int[] progresses = {93, 30, 55};
        //int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = solution2(progresses, speeds);
        for(int i : result){
            System.out.println(i);
        }


    }

}
