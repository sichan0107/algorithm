
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int n;
    static boolean[] checked;

    public static void dfs(int L) {
        System.out.println("=======================");
        System.out.println("L : " + L );

        for(boolean check : checked){
            System.out.println("check : " + check );

        }

        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (checked[i]) sb.append(i + " ");
            }

            if (sb.length() > 0) //공집합 제외
                System.out.println(sb.toString());
        } else {
            checked[L] = true; //원소 L을 포함하는 부분집합
            dfs(L + 1);
            checked[L] = false; //원소 L을 포함하지 않는 부분집합
            dfs(L+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        checked = new boolean[n+1]; //숫자 그대로를 인덱스로 사용하기위해 +1

        dfs(1);

        br.close();
    }
}

