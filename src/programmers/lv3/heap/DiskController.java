package programmers.lv3.heap;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

// LV3 디스크 컨트롤러
public class DiskController {
    static class Request implements Comparable<Request>{
        int requestTime; //요청된 시간
        int needTime; //소요되는 시간

        public Request(int requestTime, int needTime){
            this.requestTime = requestTime;
            this.needTime = needTime;
        }
        @Override
        public String toString(){
            return "requestTime : " + this.requestTime + " needTime : " + this.needTime;
        }

        @Override
        public int compareTo(Request o) {
            return this.needTime - o.needTime;
        }
    }

    public static int solution(int[][] jobs) {
        int averageTime = 0;
        PriorityQueue<Request> queue = new PriorityQueue<>(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                System.out.println("o1.needTime : " + o1.needTime);
                System.out.println("o2.needTime : " + o2.needTime);
                System.out.println("###################### ");
                return o1.needTime - o2.needTime;
            }
        }); // 최소힙으로 만들어야 빠른 작업부터 할 수 있음.

        for(int[] job : jobs){
            Request rq = new Request(job[0], job[1]);
            queue.add(rq);
        }

        for(Request rq : queue){
            System.out.println(rq.toString());
        }


        return averageTime;
    }

    public static void main(String[] args) throws IOException {
        int[][] jobs = {{0, 3}
                        , {1, 9}
                        , {2, 6}};

        System.out.println(solution(jobs));
    }
}
