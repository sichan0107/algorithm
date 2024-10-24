package programmers.lv2.bruteforce;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 피로도

/**
 *  완전탐색의 방법 중 백트래킹, DFS를 사용한다.
 *
 *  - 백트래킹 : 답을 찾다가 이 경로가 답이 아니라고 판단되면 버리고 다른 길을 찾는다 (반복문의 횟수를 줄여 효율을 챙긴다)
 *  - DFS : 최대한 깊게 내려간 뒤, 더 이상 내려갈 곳이 없을 경우 옆으로 이동한다. (스택 or 재귀로 구현)
 */

public class Tired {

    public static void main(String[] args) {
//        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
//        // primitive 타입의 boolean은 기본적으로 false로 초기화된다.
//        visit = new boolean[dungeons.length];
//        for(boolean v : visit){
//            System.out.println(v);
//        }


         System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    static boolean[] visited;
    static int count = 0;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }

    private static void dfs(int depth, int fatigue, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++){
            if (visited[i] || dungeons[i][0] > fatigue) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }


}
