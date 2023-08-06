package codingtest.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_14425 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++){
            map.put(br.readLine(), 0); // 문자열을 HashMap의 key값으로 부여
        }

        for (int i=0; i<M; i++){
            if (map.containsKey(br.readLine())) // 입력받은 문자열이 HashMap의 Key로 들어있는지 확인
                answer++;
        }

        System.out.println(answer);
    }
}
