package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_14425_2 {

    public static class Node{
        Map<Character, Node> childNode = new HashMap<>();
        boolean terminal = false;

        public void insert(String in){
            Node node = this;
            for (int i=0; i<in.length(); i++){
                char c = in.charAt(i);

                node.childNode.putIfAbsent(c, new Node()); // node에 c가 없다면 put (가지 생성)
                node = node.childNode.get(c); // 빈 노드 생성

                if (i == in.length()-1){
                    node.terminal = true;
                    return ;
                }
            }
        }

        public boolean valid(String str){
            Node node = this;

            for (int i=0; i<str.length(); i++){
                char c = str.charAt(i);

                Node findNode = node.childNode.get(c); // key값에 맞는 노드 get

                if (findNode == null)
                    return false;

                node = findNode;
            }

            return node.terminal; // 마지막 단어 여부를 확인 -> 찾는 단어라면 true
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node node = new Node();

        for (int i=0; i<N; i++){
            node.insert(br.readLine());
        }

        int answer = 0;
        for (int i=0; i<M; i++){
            if (node.valid(br.readLine()))
                answer++;
        }

        System.out.println(answer);
    }
}
