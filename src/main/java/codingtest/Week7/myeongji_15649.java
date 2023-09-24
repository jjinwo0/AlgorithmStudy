package codingtest.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class myeongji_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        visit = new boolean[N+1];

        dfs(0);

        System.out.println(sb);

    }

    public static void dfs(int dep) {
        if(dep == M) {
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visit[i]) continue;

            visit[i] = true;
            arr[dep] = i;
            dfs(dep+1);
            visit[i] = false;
        }
    }
}
