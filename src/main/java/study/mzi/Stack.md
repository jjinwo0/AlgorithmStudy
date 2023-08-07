### 💡 스택(Stack)
- 한 쪽 끝에서만 자료를 넣고 뺄 수 있는 LIFO(Last In First Out) 형식의 자료 구조
- 스마트폰에서 '뒤로 가기'를 눌렀을 때 현재 수행되는 앱이 종료되고,
  바로 직전에 수행되던 앱이 다시 나타나는 경우도 **스택**이 사용된 것 !


### 💡 스택(Stack)의 특징
- 단방향 입출력 구조 : 데이터의 들어오는 방향과 나가는 방향이 같다
- 데이터를 하나씩만 넣고 뺄 수 있다.
- 깊이 우선 탐색(DFS)에 이용된다.
- 재귀 함수의 동작 흐름과 같은 구조를 가진다.


### 💡 스택(Stack)의 연산
- 스택은 LIFO 형식을 따른다. 즉, 가장 최근에 스택에 추가한 항목이 가장 먼저 제거 될 항목
  (프링글스 과자를 생각하면 이해하기 쉽다!!)

* pop() : 스택에서 가장 위에 있는 항목을 제거
* push(item) : item을 스택의 가장 윗 부분에 추가
* peek() : 스택 가장 위에 있는 항목을 반환


### 💡 스택(Stack)의 구현
- 자바는 java.util.Stack 클래스를 통해 스택(Stack) 동작을 제공한다.

```

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<Integer> stackInt = new Stack<>();

		// Stack에 데이터 추가
		stackInt.push(1);
		stackInt.push(2);
		stackInt.push(3);

		// Stack에서 데이터 꺼내기
		System.out.println(stackInt.pop());

		// Stack의 최상단 값 출력(제거하지 않음)
		System.out.println(stackInt.peek());

		// Stack에서 데이터 꺼내기
		System.out.println(stackInt.pop());
	}
}

```

#### 🕹️ push 동작 (값 추가)
- Stack 클래스는 push(value) 메소드를 이용해서 스택에 값을 추가할 수 있다.
- add(value) 메소드로도 값을 추가할 수 있다.

```
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<Integer> stackInt = new Stack<>();

		// Stack에 데이터 추가
		stackInt.push(1);
		stackInt.push(2);
		stackInt.push(3);

		System.out.println(stackInt);

	}
}
```

```
// 출력
[1, 2, 3]
```

위 순서대로 데이터를 스택에 추가했다면, pop() 메소드 3번 호출 시,
"Data3", "Data2", "Data1" 순으로 데이터가 꺼내지게 된다.

#### 🕹️ pop 동작 (값 제거)
- Stack 클래스는 pop() 메소드를 이용해서 스택으로부터 값을 제거할 수 있다.

```
import java.util.Stack;

class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt.pop());
        System.out.println(stackInt);
    }
}
```

```
// 출력
3
[1, 2]
```

#### 🕹️ peek 동작(최상단 값 확인)
- 스택의 최상단(Top)에 있는 데이터를 확인만 하고 스택에서 제거하지 않는다.
- 스택이 비어있을 경우 peek()를 호출하면 NoSuchElementException 예외 발생

```
import java.util.Stack;

class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt.peek());
    }
}
```

```
 // 출력
 3
```

#### 🕹️ search 동작
- 메소드의 인자를 스택에서 검색하여 해당 위치를 반환한다.
- 해당 인자가 여러개일 경우, 마지막 위치를 반환한다.
- 여기서 위치는 인덱스가 아닌 **빠져나오는 순서**를 뜻한다
- 찾는 값이 스택에 없을 경우, -1을 반환한다.

```
class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        stackInt.push(1);
        // [1, 2, 3, 1]

        System.out.println(stackInt.search(2));
        System.out.println(stackInt.search(1));
        System.out.println(stackInt.search(4));
    }
}
```

```
// 출력
3
1
-1
```

#### 🕹️ 기타 동작들
- size() : 현재 스택에 들어있는 데이터의 개수를 리턴
- clear() : 스택에 있는 모든 데이터를 한번에 날려줌 (데이터 값들을 하나하나 null 값으로 할당)
- empty() : 스택이 비어있는지 여부를 판단
- contains() : 스택에 특정 데이터가 포함되어 있는지 체크