package codingtest.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class myeongji_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); // 입력받을 그룹의 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수

        HashMap<String, String[]> team = new HashMap<>(); // 팀명과 멤버명이 담긴 배열로 이루어진 해시맵
        HashMap<String, String> girl = new HashMap<>(); // 멤버명과 팀명으로 이루어진 해시맵


        while(N-->0){
            String tName = br.readLine(); // 팀명을 입력받음
            int K = Integer.parseInt(br.readLine()); // 멤버 수를 입력 받음
            String[] arr = new String[K]; // 멤버명을 저장할 배열 생성
            while(K-->0) {
                String name = br.readLine();
                girl.put(name, tName); // 멤버명 : 팀명 으로 이루어진 값을 해시맵에 저장
                arr[K] = name;
            }
            Arrays.sort(arr); // 사전순으로 출력하기 위해 미리 정렬함
            team.put(tName, arr); // 팀명 : 멤버 배열 로 이루어진 값을 해시맵에 저장
        }

        while(M-->0){
            String temp = br.readLine(); // 멤버 이름 또는 팀명을 입력 받음

            int pr = Integer.parseInt(br.readLine()); // 퀴즈의 종류를 입력 받음 (0 or 1)

            switch(pr) {
                case 0:
                    for(String s : team.get(temp))
                        System.out.println(s);
                    break;

                case 1:
                    System.out.println(girl.get(temp));
            }
        }





    }
}
