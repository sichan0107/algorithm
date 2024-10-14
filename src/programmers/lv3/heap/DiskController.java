package programmers.lv3.heap;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// LV3 디스크 컨트롤러

/**
 *
 *  누적되는 needTime - 현재 requestTime의 값이 제일 적은 순서대로 sort
 *  -> 바로바로 실행될 수 있게 
 *
 */

public class DiskController {
    //static class Request implements Comparable<Request>{
    static class Request {
        int requestTime; //요청된 시간
        int needTime; //소요되는 시간

        int currentTime;

        public Request(int requestTime, int needTime){
            this.requestTime = requestTime;
            this.needTime = needTime;

            if(this.requestTime == 0){
                this.currentTime = this.needTime;
            }else{
                this.currentTime = 0;
            }

        }
        @Override
        public String toString(){
            return "requestTime : " + this.requestTime + " needTime : " + this.needTime + " currentTime : " + this.currentTime;
        }

    }

    public static int solution(int[][] jobs) {
        int averageTime = 0;
        int finishJobIdx = 0;
        int currentTime = 0;
        // input arr의 순서를 요청시간 기준으로 오름차순 정렬 (먼저 요청된 순서로)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        currentTime = jobs[0][1];

        // 소요시간이 가장 적은 것을 기준으로 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int i = 0;
        while(jobs.length > finishJobIdx ){

            // currentTime = 3,
            while ( currentTime > jobs[finishJobIdx][0]){
                queue.add(jobs[finishJobIdx]);
                finishJobIdx++;
            }

            if(currentTime < jobs[finishJobIdx][0]){
                currentTime = jobs[finishJobIdx][0];
            }
        }

        while (!queue.isEmpty()){
            System.out.println("poll : " + queue.poll());
        }

        return averageTime;
    }


    public static void main(String[] args) throws IOException {
        int[][] jobs = {{0, 3}
                        , {1, 9}
                        , {2, 6}};

//        int [][] jobs2 = {{0,5},
//                        {1,2},
//                        {2,9},
//                        {3,3}};

        //System.out.println(jobs.length);
        System.out.println(solution(jobs));
        //System.out.println(solution(jobs2));
    }
}
