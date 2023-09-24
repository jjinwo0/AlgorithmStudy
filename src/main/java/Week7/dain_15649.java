import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //static
    static boolean[] visited;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //전체 숫자의 개수
        int M = Integer.parseInt(st.nextToken()); //선택해야 할 숫자의 개수 (수열)

        //배열 초기화
        arr = new int[M];
        visited = new boolean[N];

        //DFS함수 호출
        dfs(N, M, 0);

        //결과 출력
        System.out.println(sb);
    }

    // DFS 함수 정의
    public static void dfs(int n, int m, int depth) {
        //depth가 m과 같다면 (주어진 수열만큼 돌았다면)
        if (depth == m) {
            //문자열에 저장
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n"); //개행
            return; //문자열 저장 이후, 재귀함수를 빠져나가기 위해 return;
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; //방문 표시
                arr[depth] = i + 1; //i+1만큼 배열에 저장
                dfs(n, m, depth + 1); //다음 숫자 호출을 위해 depth + 1 한후 재귀함수 호출(return이 되기까지 for문을 돌린다.)
                visited[i] = false; //자식 노드들의 방문을 마치면 초기화를 통해 다시 백트래킹 함
            }
        }
    }
}
