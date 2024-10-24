package programmers.lv2.bfsdfs;

public class TagetNumber {

    static int answer = 0;
    public static int solution(int[] numbers, int target) {

        dfs(0, numbers, target);
        System.out.println(answer);
        return answer;
    }

    // 모든 수를 다 더하는것부터 시작
    // target 값이 안나오면
    public static void dfs(int idx, int[] numbers, int target){
        int total = 0;

        for(int i=0; i<numbers.length ; i++){
            total = total + numbers[i];
        }
    }


    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        solution(numbers, target);
    }
}
