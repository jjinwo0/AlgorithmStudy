import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄에서 N과 M을 읽어옴
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N: 팀의 수
        int M = Integer.parseInt(st.nextToken()); // M: 질문의 수

        // 팀 이름과 팀 멤버를 저장하는 HashMap 생성
        HashMap<String, String> map = new HashMap<>();

        // N개의 팀에 대한 정보를 입력 받음
        for (int i = 0; i < N; i++) {
            String team = br.readLine(); // 팀 이름을 읽어옴
            int num = Integer.parseInt(br.readLine()); // 팀 멤버 수를 읽어옴

            StringBuilder value = new StringBuilder();

            // 팀 멤버들의 이름을 읽어와 공백으로 구분하여 StringBuilder에 저장
            for (int j = 0; j < num; j++) {
                value.append(br.readLine()).append(" ");
            }

            // 팀 이름과 팀 멤버들을 HashMap에 저장
            map.put(team, value.toString().trim());
        }

        StringBuilder sb = new StringBuilder();

        // M개의 질문에 대한 답변
        for (int i = 0; i < M; i++) {

            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                // k는 1일 때, 각 팀의 멤버 목록을 확인하여 질문 문자열을 포함하는 팀을 출력
                for (Map.Entry<String, String> m : map.entrySet())
                    if (m.getValue().contains(s)) sb.append(m.getKey()).append("\n");
            } else {
                // 그 외, 질문 문자열과 일치하는 팀의 멤버들을 사전순으로 정렬하여 출력
                String[] result = map.get(s).split(" ");
                Arrays.sort(result);
                for (String member : result) {
                    sb.append(member).append("\n");
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString());

    }
}
