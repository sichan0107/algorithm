package baekjoon.recursive;

public class MergeSort {
    public static void merge(int[] arr, int left, int middle, int right) {
        // 구간의 크기를 계산
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 임시 배열 생성
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // 원래 배열에서 임시 배열로 데이터 복사
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        // 인덱스 초기화
        int i = 0, j = 0, k = left;

        // 두 배열을 비교하면서 병합
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i++];
            } else {
                arr[k] = rightArr[j++];
            }
            k++;
        }

        // 왼쪽 배열에 남은 원소를 복사
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // 오른쪽 배열에 남은 원소를 복사
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // 병합 정렬 알고리즘을 수행하는 함수
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 중간 인덱스 계산
            int middle = (left + right) / 2;
            // 왼쪽 부분 배열 정렬
            mergeSort(arr, left, middle);
            // 오른쪽 부분 배열 정렬
            mergeSort(arr, middle + 1, right);
            // 병합
            merge(arr, left, middle, right);
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        // 정렬할 배열
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        // 정렬 전 배열 출력
        System.out.println("Unsorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        // 병합 정렬 실행
        mergeSort(arr, 0, arr.length - 1);

        // 정렬 후 배열 출력
        System.out.println("\nSorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
