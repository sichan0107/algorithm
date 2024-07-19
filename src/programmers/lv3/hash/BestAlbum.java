package programmers.lv3.hash;

import java.io.IOException;
import java.util.*;

public class BestAlbum {
    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

    풀이 : Comparator를 사용했지만 Album 객체를 만들었기 때문에 Comparable도 쓸 수 있을듯
    의견 : 해시보단 정렬에 더 초점을 두는 듯한 문제... 
     */

    public static class Album{
        int idx;
        int play;

        public Album(int idx,  int play){
            this.idx = idx;
            this.play = play;
        }

        public  int getIdx(){
            return this.idx;
        }

        public  int getPlay(){
            return this.play;
        }

        @Override
        public  String toString(){
            return "idx : " + this.idx + " play : " + this.play;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        // 1. 가장 많이 플레이 된 장르 순서대로 저장
        for(int i=0; i < genres.length; i++){
            countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keySet = new ArrayList<>(countMap.keySet());

        keySet.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int result = countMap.get(o2) - countMap.get(o1);
                if(result == 0){
                    return -1;
                }
                return result;
            }
        });

        // 2. 가장 많이 플레이된 장르의 플레이 순서대로 idx 정렬

        ArrayList<Integer> answer = new ArrayList<>();

        int answerIdx = 0;
        for(String key : keySet){
            System.out.println("key : " + key);
            int tempIdx = 0;
            ArrayList<Album> albumArrayList = new ArrayList<>();

            for (int i=0; i<genres.length; i++){
                if(genres[i].equals(key) ){
                    Album  album = new Album(i, plays[i]);
                    albumArrayList.add(album);
                }
            }

//            Comparator<Album> comparator = Comparator.comparing(Album::getPlay, Comparator.reverseOrder())
//                    .thenComparing(Album::getIdx);
//
//            Collections.sort(albumArrayList, comparator);

            albumArrayList.sort(new Comparator<Album>() {
                @Override
                public int compare(Album o1, Album o2) {
                    if(o1.play == o2.play){
                        return o1.idx - o2.idx;
                    }
                    return o2.play - o1.play;
                }
            });
            answer.add(albumArrayList.get(tempIdx).idx);
            if(albumArrayList.size() != 1) {
                answer.add(albumArrayList.get(tempIdx + 1).idx);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        //String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        //int[] plays = {500, 600, 150, 800, 2500}; //4, 1, 3, 0

        String[] genres = {"classic", "pop"};
        int[] plays = {10, 10}; //4, 1, 3, 0


        int[] answer = solution(genres, plays);
        for(int i : answer){
            System.out.println(i);

        }

    }
}
