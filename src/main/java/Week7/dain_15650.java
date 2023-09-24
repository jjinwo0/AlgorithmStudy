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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //배열 초기화
        arr = new int[M];
        visited = new boolean[N];

        //함수 호출
        dfs(N, M, 0, 0);

        //결과 출력
        System.out.println(sb);
    }


    public static void dfs(int n, int m, int next, int depth) {
        // depth가 m과 같다면 (주어진 수열만큼 돌았다면)
        if (depth == m) {
            // 문자열에 저장
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n"); // 개행 문자로 조합을 구분
            return; // 문자열 저장 후, 재귀 함수를 빠져나가기 위해 return;
        }

        //숫자의 중복 선택을 피하기 위해 next부터 시작
        for (int i = next; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; //방문 표시
                arr[depth] = i; //선택한 숫자를 배열에 저장
                dfs(n, m, i + 1, depth + 1); // 다음 숫자 호출을 위해 i + 1로 재귀 함수 호출
                visited[i] = false; // 자식 노드들의 방문을 마치면 초기화를 통해 다시 백트래킹 수행
            }
        }
    }
}
