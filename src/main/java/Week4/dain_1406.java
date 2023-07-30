import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력 출력 메소드 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //String을 배열에 쪼개서 저장
        String str[] = br.readLine().split("");

        //왼쪽스택 선언
        Stack<String> Lstack = new Stack<String>();

        //왼쪽 스택에 str배열값들 저장
        for (String s : str) {
            Lstack.push(s);
        }

        //숫자 입력받음
        int N = Integer.parseInt(br.readLine());

        //오른쪽 스택 선언
        Stack<String> Rstack = new Stack<String>();

        //N이 0보다 클때까지 반복 N-- 값 줄이기
        while (N-- > 0) {
            //command 배열에 공백 제외하고 값 넣기
            String command[] = br.readLine().split(" ");

            //command0의 글자가 "P"라면 왼쪽 스택에 command1 저장 (공백 제외된 $문자값)
            if (command[0].equals("P")) {
                Lstack.push(command[1]);
            }
            //command0의 글자가 "L"이면서 왼쪽 스택이 공백이 아닐때(맨처음커서이면 무시를 위한) 오른쪽 스택에 왼쪽 스택 최상위값 저장
            else if (command[0].equals("L")) {
                if (!Lstack.isEmpty()) {
                    Rstack.push(Lstack.pop());
                }
            }
            //command0의 글자가 "D"이면서 오른쪽 스택이 공백이 아닐때(맨뒤 커서이면 무시를 위한) 오른쪽 스택에 왼쪽 스택 최상위값 저장
            else if (command[0].equals("D")) {
                if (!Rstack.isEmpty()) {
                    Lstack.push(Rstack.pop());
                }
            }
            //command0의 글자가 "B"이면서 왼쪽 스택이 공백이 아닐때(맨앞 커서이면 무시를 위한) 왼쪽 스택 문자 하나 pop
            else if (command[0].equals("B")) {
                if (!Lstack.isEmpty()) {
                    Lstack.pop();
                }
            }
        }

        //stack은 LIFO형식이기 때문에 오른쪽 스택에 다시 pop
        while (!Lstack.isEmpty()) {
            Rstack.push(Lstack.pop());
        }

        //오른쪽 스택의 최상위부터 출력
        while (!Rstack.isEmpty()) {
            bw.write(Rstack.pop());
        }

        bw.flush();
        bw.close();
    }
}