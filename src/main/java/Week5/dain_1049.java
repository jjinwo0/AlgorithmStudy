import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //최대값 설정
        int six = 1000;
        int num = 1000;
        //결과값 변수
        int min = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            //입력받은 값 중에 가장 작은 값만 저장
            six = Math.min(six, Integer.parseInt(st.nextToken()));
            num = Math.min(num, Integer.parseInt(st.nextToken()));
        }


        //가장 싼 패키지로만 할지 vs 가장 싼 낱개로만 할지 vs 가장 싼 팩 + 낱개
        min = Math.min(((N / 6) + 1) * six, N * num);
        min = Math.min(min, (N / 6) * six + (N % 6) * num);

        System.out.println(min);
    }
}