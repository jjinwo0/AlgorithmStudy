import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N: 집합 A의 크기
        int M = Integer.parseInt(st.nextToken()); // M: 집합 B의 크기

        List<String> list = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        // 집합 A에 속하는 문자열을 입력받아 해시셋에 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 집합 B의 원소를 입력받아 집합 A에 속하는지 확인하고 결과 리스트에 추가
        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (set.contains(input)) {
                list.add(input);
            }
        }

        // 결과 리스트를 정렬
        Collections.sort(list);

        // 결과 출력
        System.out.println(list.size()); // 결과 리스트의 크기 출력 (겹치지 않는 원소의 개수)
        for (String s : list) {
            System.out.println(s); // 겹치는 원소들을 사전 순으로 출력
        }
    }
}
