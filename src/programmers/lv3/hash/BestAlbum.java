package programmers.lv3.hash;

import java.io.IOException;
import java.util.*;

public class BestAlbum {
        /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     */

    public static class Album{
        int idx;
        //String genre;
        int play;

        public Album(int idx,  int play){
            this.idx = idx;
            //  this.genre = genre;
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

        int allSongCount = genres.length;

        // 1. 가장 많이 플레이 된 장르 순서대로 저장
        for(int i=0; i < allSongCount; i++){
            if(countMap.get(genres[i]) == null){
                countMap.put(genres[i], plays[i]);
            }else{
                countMap.put(genres[i], countMap.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList<>(countMap.keySet());

        keySet.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return countMap.get(o2).compareTo(countMap.get(o1));
            }
        });

        // 2. 가장 많이 플레이된 장르의 플레이 순서대로 idx 정렬

        int[] answer = new int[keySet.size() * 2];

        int answerIdx = 0;
        for(String key : keySet){
            int tempIdx = 0;
            System.out.println("===== key : " + key);
            ArrayList<Album> albumArrayList = new ArrayList<>();
            for (int i=0; i<genres.length; i++){
                if(genres[i].equals(key) ){
                    Album  album = new Album(i, plays[i]);
                    albumArrayList.add(album);
                }
            }

            //Comparator<Album> comparator = Comparator.comparing(Album::getPlay, Comparator.reverseOrder())

            albumArrayList.sort(Collections.reverseOrder((a, b) -> a.play - b.play )).thenComparing(Album::getIdx);



            answer[answerIdx] = albumArrayList.get(tempIdx).idx;
            answerIdx++;
            tempIdx++;
            answer[answerIdx] = albumArrayList.get(tempIdx).idx;
            answerIdx++;

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500}; //4, 1, 3, 0


        int[] answer = solution(genres, plays);
        for(int i : answer){
            System.out.println(i);

        }

    }
}
