package programmers.lv2.bfsdfs;

public class TagetNumber {

    static int answer = 0;
    static int calResult = 0;
    public static int solution(int[] numbers, int target) {

        dfs(0,0, numbers, target);
        System.out.println(answer);
        return answer;
    }

    // 모든 수를 다 더하는것부터 시작
    // target 값이 안나오면
    // numbers = 1,1,1,1,1
    public static void dfs(int sum, int idx, int[] numbers, int target){
        if(numbers.length == idx){
            if(sum == target) answer++;
            return;
        }

        dfs(sum + numbers[idx], idx+1, numbers, target);
        dfs(sum - numbers[idx], idx+1, numbers, target);


    }


    public static void main(String[] args) {
        //int[] numbers = {1, 1, 1, 1, 1};
        //int target = 3;

        int[] numbers2 = {4,1,2,1};
        int target2 = 4;
       // solution(numbers, target);
        solution(numbers2, target2);
    }
}
