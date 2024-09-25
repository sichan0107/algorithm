package programmers.lv1.bruteforce;

import java.io.IOException;
import java.util.Arrays;

// 최소직사각형

public class MinSquare {

    public static  int solution(int[][] sizes) {
        int small = 0;
        int big = 0;

        for(int i=0; i < sizes.length ; i++){
            int[] size = sizes[i];
            int s = 0;
            int b = 0;

            if(size[0] >= size[1]){
                b = size[0];
                s = size[1];
            }else {
                b = size[1];
                s = size[0];
            }

            if(small == 0 && big == 0){
                small = s;
                big = b;
            }

            small = Math.max(small, s);
            big = Math.max(big, b);
        }

        Arrays.stream(sizes).flatMap(size -> )

        return big * small;
    }

    public static int solution2(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) ->
                new int[]{Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).get();
    }

    public static void main(String[] args) throws IOException {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 4000
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; // 120
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}; // 133

        System.out.println(solution(sizes1));
        System.out.println(solution(sizes2));
        System.out.println(solution(sizes3));
    }
}
