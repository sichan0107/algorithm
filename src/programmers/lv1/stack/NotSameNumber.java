package programmers.lv1.stack;
import java.io.IOException;
import java.util.*;

/**
 *  LV1 Stack / Queue 같은 숫자는 싫어
 */

public class NotSameNumber {
    public static int getArraySize(int[] arr) {
        int size = 1;

        for(int i=0; i<arr.length; i++) {
            if(i < arr.length -1 ) {
                if(arr[i] != arr[i+1]) {
                    size++;
                }
            }else{
                continue;
            }
        }
        return size;
    }


    public static int[] solution(int []arr) {
        int[] answer = new int[getArraySize(arr)];
        int size = 0;
        int idxAnswer = 0;

        if(answer.length == 1){
            answer[0] = arr[0];
            return answer;
        }

        if(arr.length == 2 && arr[arr.length - 2] == arr[arr.length - 1]) {
            answer[0] = arr[0];
            return answer;
        }

        for(int i=0; i<arr.length; i++) {
            if(i < arr.length -1 ) {
                if(arr[i] != arr[i+1]) {
                    answer[idxAnswer] = arr[i];
                    idxAnswer++;
                }
            }else {
                if(answer[idxAnswer - 1] != arr[i]) {
                    answer[idxAnswer] = arr[i];
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        //int[] arrs = {1,1,3,3,0,1,1};
        //int[] arrs = {0,1,0,1};
        int[] arrs = {0,0,0,0};

        System.out.println(getArraySize(arrs));

        int[] result = solution(arrs);

        System.out.println("==========");

        for(int i: result){
            System.out.println(i);
        }

    }
}
