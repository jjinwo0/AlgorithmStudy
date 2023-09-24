import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 출력을 위한 BufferedWriter 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 문자열을 하나씩 나눠서 배열에 저장
        String str[] = br.readLine().split("");

        // 왼쪽 스택 (Lstack)을 생성하여 문자열을 하나씩 넣음
        Stack<String> Lstack = new Stack<String>();

        for (String s : str) {
            Lstack.push(s);
        }

        // 명령어의 개수를 입력 받음
        int N = Integer.parseInt(br.readLine());

        // 오른쪽 스택 (Rstack)을 생성
        Stack<String> Rstack = new Stack<String>();

        // 입력된 명령어들을 처리
        while (N-- > 0) {
            // 공백을 기준으로 명령어와 인자를 분리하여 배열에 저장
            String command[] = br.readLine().split(" ");

            if (command[0].equals("P")) {
                // "P" 명령어일 때, 왼쪽 스택에 문자열을 추가
                Lstack.push(command[1]);
            } else if (command[0].equals("L")) {
                // "L" 명령어일 때, 왼쪽 스택에서 오른쪽 스택으로 문자열을 이동
                if (!Lstack.isEmpty()) {
                    Rstack.push(Lstack.pop());
                }
            } else if (command[0].equals("D")) {
                // "D" 명령어일 때, 오른쪽 스택에서 왼쪽 스택으로 문자열을 이동
                if (!Rstack.isEmpty()) {
                    Lstack.push(Rstack.pop());
                }
            } else if (command[0].equals("B")) {
                // "B" 명령어일 때, 왼쪽 스택에서 문자열을 삭제 (backspace)
                if (!Lstack.isEmpty()) {
                    Lstack.pop();
                }
            }
        }

        // 왼쪽 스택의 문자열을 오른쪽 스택으로 모두 이동
        while (!Lstack.isEmpty()) {
            Rstack.push(Lstack.pop());
        }

        // 오른쪽 스택에 있는 문자열을 BufferedWriter를 사용하여 출력
        while (!Rstack.isEmpty()) {
            bw.write(Rstack.pop());
        }

        // 출력 버퍼를 비우고 닫음
        bw.flush();
        bw.close();
    }
}
