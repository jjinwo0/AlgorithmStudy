## 버퍼(Buffer)
버퍼(Buffer)는 <span style='color:red'>**데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역**</span>이다.

쉽게 생각하면 지하철 플랫폼에 비교해볼 수 있다.
지하철을 타고 이동하고 싶은 많은 사람들이 가변적으로 플랫폼에 대기하고
지하철은 이 사람들을 태워 순식간에 원하는 곳으로 한번에 이동한다는 것!

여기서 중요한 점은, 매번 사람들이 들어올 때마다 이동하는 것이 아니라
어느정도 사람이 모이고 지하철이 도착해야 이동이 가능하다는 것이다.

>버퍼의 장점
>1. 문자를 묶어서 한번에 전달하므로 전송시간에 적게 걸려 성능이 향상된다.
>2. 사용자가 문자를 잘못 입력했을 경우 수정할 수 있다

### BufferedReader

BufferedReader로 하나의 정수를 입력받는다고 하면,

```java
    BufferedReader br =  BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine(); //String
    int userInputNumber = Integer.parseInt(br.readLine()); //Int
```
와 같은 작업이 수행된다.

입력 받을 때 readLine()이라는 메서드를 사용하는데, 반드시 주의해야할 점이 있다.

>첫째. readLine() 이용 시 리턴값이 String으로 고정되기때문에 String이 아닌 다른 자료형으로 입력을 받기 위해서는 형변환을 꼭 해주어야 한다.
둘째. 예외처리를 꼭 해주어야 한다. readLine() 할 때마다 try&catch문을 활용해도 되지만, 대부분 throws IOException을 사용한다.

### Scanner와의 차이
Scanner는 입력을 읽어들이는 과정에서 정규 표현식을 적용하고, 입력값 분할, 파싱 과정을 스스로 제공하기 때문에 느리다.

BufferedReader는 모든 입력을 Char형으로, Buffer를 사용하여 받는다.
하나의 글자에 대해 전달되는 것이 아닌, 전체 입력(혹은 Buffer 단위)에 대해서 전달되기 때문에 속도 부분에서 Scanner보다 매우 유리하다.



참고 : https://velog.io/@roycewon/BufferedReader%EB%A5%BC-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90