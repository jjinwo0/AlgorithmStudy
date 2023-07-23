import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //결과값 변수
        int res = 0;

        //해쉬맵 선언
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        //map에 집합 S에 포함되어 있는 문자열 저장
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        //입력받은 문자가 집합 S에 포함되는 문자열이면 res값++, containsKey로 Key값이 있는 지 확인(있으면 true,없으면 false 반환)
        for(int i = 0; i < M; i++) {
            if(map.containsKey(br.readLine())) res++;
        }

        //결과 출력
        System.out.println(res);
    }
}