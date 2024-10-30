package baekjoon.recursive;

import java.util.Arrays;

// 알고리즘 수업 - 병합 정렬1
public class N24060 {

    static int[] sortedArr;


    //{4, 5, 1, 3, 2};
    public static void mergeSort(int[] unsortedArr, int left, int right){

        System.out.println(">>> Input Arr 시작");
        showArr(unsortedArr);
        System.out.println("left : " + left + " right : " + right);
        System.out.println(">>> Input Arr 끝");


        if(left >= right) {
            //System.out.println("left : " + left + " right : " + right);
            return;
        }

        int mid = (left + right) / 2;
        int[] leftArr = Arrays.copyOfRange(unsortedArr, left, mid + 1);
        int[] rightArr= Arrays.copyOfRange(unsortedArr, mid + 1, right+1);

        showArr(leftArr);
        showArr(rightArr);

        mergeSort(leftArr, left, mid); // 4, 5, 1
        mergeSort(rightArr, mid + 1, right); // 3 , 2


        int i=0, j=0, k=left;


        // 3. 정렬 비교
        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] > rightArr[j]){
                sortedArr[k] = rightArr[j++];
            }else {
                sortedArr[k] = leftArr[i++];
            }
            k++;
        }

        System.out.println(" 정렬 후 남은거 합치기 전 ----- 시작");
        showArr(sortedArr);
        System.out.println(" 정렬 후 남은거 합치기 전 ----- 끝 ");

        // 왼쪽 배열에 남은 원소를 복사
        while (i < leftArr.length) {
            sortedArr[k++] = leftArr[i++];
        }

        // 오른쪽 배열에 남은 원소를 복사
        while (j < rightArr.length) {
            sortedArr[k++] = rightArr[j++];
        }

        System.out.println("========= 순환 결과 시작======");

        showArr(sortedArr);
        System.out.println("========= 순환 결과 끝 ======");



    }

    public static void showArr (int[] arr){
       String result = "";
        for(int i : arr){
            result = result + " " + i;
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 3, 2};
        sortedArr = new int[arr.length];


        mergeSort(arr, 0, arr.length-1);
    }
}
