package codingtest.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class myeongji_15650 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N+1];

        dfs(1,0);
        System.out.println(sb);

    }

    public static void dfs(int at, int dep) {
        if(dep == M) {
            for(int val:arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=N; i++){
            if(!visit[i]) {
                visit[i] = true;
                arr[dep] = i;
                dfs(i + 1, dep + 1);
                visit[i] = false;
            }
        }
    }
}
