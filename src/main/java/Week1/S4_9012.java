package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_9012 {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<str.length(); j++){
                char c = str.charAt(j);

                if (c == '(') // 열리는 괄호는 스택에 쌓아둠
                    stack.push(c);
                else if(c == ')'){
                    if (stack.isEmpty()){
                        stack.push(c); // )가 추가됨으로써 empty 검사 시 반드시 False
                        break;
                    } else stack.pop(); // 올바른 괄호 짝이 맞았다는 의미 -> pop()
                }
            }

            if (stack.isEmpty())
                System.out.println("YES");
            else System.out.println("NO");

            stack.clear();
        }
    }
}