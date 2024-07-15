package structure;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static void main(String[] args){
        Vertex v1 = new Vertex('A');
        Vertex v2 = new Vertex('B');
        Vertex v3 = new Vertex('C');
        Vertex v4 = new Vertex('D');
        Vertex v5 = new Vertex('E');
        Vertex v6 = new Vertex('F');
        Vertex v7 = new Vertex('G');
        Vertex v8 = new Vertex('H');

        Graph graph = new Graph(8);
        graph.addEdge(v1, v2); // A - B 연결
        graph.addEdge(v1, v3); // A - C 연결
        graph.addEdge(v2, v4); // B - D 연결
        graph.addEdge(v2, v5); // B - E 연결
        graph.addEdge(v3, v6); // C - F 연결
        graph.addEdge(v3, v7); // C - G 연결
        graph.addEdge(v5, v6); // E - F 연결
        graph.addEdge(v5, v8); // E - H 연결
        graph.addEdge(v6, v7); // F - G 연결

        graph.bfs(v2);

        // Disconnected 된 Graph일 경우 아래와 같이 방문 상태가 아닌 모든 정점에서 부터 시작하면 된다.
        // 사실, 아래와 같이 별도의 Class로 Vertex를 정의했고 그 안에서 인접 정점을 지정하였기 때문에 아래와 같이 배열을 생성함
        // 실제로 인접 리스트 방식으로 생성하면 단순히 배열을 순환하면 된다.
        // 참조 : https://www.geeksforgeeks.org/bfs-disconnected-graph/?ref=rp

        /*
        Vertex[] vertexes = {v1, v2, v3, v4, v5, v6, v7, v8};
        for(Vertex v : vertexes){
            if(!v.visited) {
                graph.bfs(v);
            }
        }
         */

    }

    // 정점 데이터를 저장하는 클래스
    private static class Vertex{
        char data; // 현재 정점의 데이터
        boolean visited = false; // 현재 정점을 이미 방문 했는지 확인(Cycle 방지)

        // 현재 정점의 인접 정점 리스트
        LinkedList<Vertex> adList = new LinkedList<>();
        public Vertex(char data){
            this.data = data;
        }
    }

    private int v; // 정점의 개수
    public Graph(int v){
        this.v = v;
    }

    // Source 정점에서 Dest 정점을 이어주는 메소드
    // 상호 연결을 수행해줌.
    public void addEdge(Vertex s, Vertex d){
        s.adList.add(d);
        d.adList.add(s);
    }

    // BFS를 수행하는 메소드
    // 탐색 시작할 Vertex를 parameter로 전달달
    public void bfs(Vertex s){
        Queue<Vertex> queue = new LinkedList<>();
        s.visited = true; // 시작 정점을 우선 탐색 완료 처리
        queue.offer(s); // 시작 정점 큐에 추가

        StringBuilder builder = new StringBuilder();
        // 더 이상 탐색할 정점이 없기 전까지 계속 반복 수행
        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            builder.append(current.data).append(" ");

            for(Vertex v : current.adList){
                // 현재 방문이 완료된 정점이 아니라면 다음 방문에 추가!
                if(!v.visited){
                    queue.offer(v);
                    v.visited = true; // 방문 완료 처리
                }
            }
        }
        System.out.println(builder);
    }
}
