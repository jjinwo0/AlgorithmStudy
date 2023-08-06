### 시작하기에 앞서...
코딩테스트를 연습하면서 어떠한 값을 기준으로 정렬을 할 때 또는 분류를 할 때 HashMap을 활용할 때가 많다. 단순하게 "Key값과 Value값으로 이루어져있다."라는 부분을 제외하곤 이해도가 부족하여 심화적인 활용에 힘든 점이 많았다. 따라서 이번 기회를 통해 HashMap과 친해지기 위해 포스팅하려 한다.

---

## HashMap 이란?
![](https://velog.velcdn.com/images/jjinwo0/post/59a58935-e25b-44a5-8e5d-b350c8119663/image.png)

> **Map 인터페이스를 구현한 Map 컬렉션 중 하나**

HashMap은 Map의 구현체입니다. Map은 Key값과 Value값으로 구성된 **Entry 객체**를 저장하는 구조를 가지고 있는 자료구조입니다. Key값은 고유해야하며, Value값은 중복되어도 괜찮습니다. 따라서, 같은 Key값으로 put된다면 해당 Key값과 묶여있던 Value값은 가장 최근 push된 Value값으로 새롭게 대체됩니다. 이름에서 알 수 있듯이 해싱(Hashing)을 사용하므로 많은 양의 데이터를 검색하는 데 뛰어난 성능을 보입니다. Key값과 Value값이 담기는 위치는 사용자가 알 수 없습니다. 따라서 일반적으로 코딩테스트에서 활용할 때 Key값 또는 Value값을 정렬하여 사용하기 쉽도록 조작하는 경우가 많습니다.

---

## HashMap 활용

### HashMap 생성
- 일반적인 HashMap 생성
``` java
import java.util.HashMap;

HashMap<Integer, Integer> hashmap1 = new HashMap<>();
```

- HashMap의 초기 용량을 지정하여 생성
``` java
import java.util.HashMap;

HashMap<Integer, Integer> hashmap2 = new HashMap<>(30);
```

- 다른 HashMap의 모든 값을 가진 HashMap 생성
``` java
import java.util.HashMap;

HashMap<Integer, Integer> hashmap3 = new HashMap<>();
HashMap<Integer, Integer> hashmap4 = new HashMap<>(hashmap4);
```

- 초기값을 넣고 HashMap 생성
``` java
import java.util.HashMap;

HashMap<Integer, Integer> hashmap5 = new HashMap<>(){
	put(1, 100); // key: 1, value: 100
};
```
HashMap은 새로운 값이 들어오게 되면 List와 같이 공간을 늘리게 됩니다. 하지만 List와는 다르게 Key값과 Value값이 동시에 들어오게 되므로, 값을 위한 공간을 두 배로 늘려야 합니다. 여기서 메모리에 과부하가 발생할 수 있으므로 초기 저장 데이터의 크기를 알고 있다면 HashMap의 초기 용량을 지정해주는 것이 좋습니다.

### HashMap 값 추가
``` java
import java.util.HashMap;

HashMap<Integer, Integer> hashmap = new HashMap<>();

hashmap.put(1, 10);
hashmap.put(2, 20);
hashmap.put(3, 30);
hashmap.put(1, 40); // 새로운 값으로 대체
```
HashMap에 값을 담고자 한다면 put메소드를 사용합니다. put메소드에 key, value값 순으로 파라미터를 구성하여 사용하고, 같은 key값에 다른 value값을 사용한다면 가장 최근에 put한 value값으로 대체됩니다.

### HashMap 값 삭제
``` java
import java.util.HashMap;

HashMap<Integer, Integer> hashmap = new HashMap<>();

hashmap.put(1, 10);
hashmap.put(2, 20);

hashmap.remove(1); // key값이 1인 공간의 값 제거
hashmap.clear(); // hashmap의 모든 값 제거
```

### HashMap 값 출력
``` java
import java.util.*;

HashMap<Integer, Integer> hashmap = new HashMap<>();

hashmap.put(1, 10);
hashmap.put(2, 20);

System.out.println(hashmap) // 전체 출력
System.out.println(hashmap.get(1)) // key: 1의 value 출력

// entrySet() 활용
for (Entry<Integer, Integer> entry : hashmap.entrySet()) {
    System.out.println("key: "+entry.getKey()+", value: "+entry.getValue());
}
//key: 1, value: 10
//key: 2, value: 20

// keySet() 활용
for (Integer i : hashmap.keySet()) {
	System.out.println("key: "+i+", value: "+hashmap.get(i));
}
//key: 1, value: 10
//key: 2, value: 20
```
HashMap의 변수명을 그대로 출력하면 중괄호({})안에 전체 key, value값이 담겨 나오게 됩니다.
특정 key값의 value값을 가져오려면, key값을 get()메서드의 파라미터로 담아 출력합니다.
entrySet()은 getKey()메서드와 getValue()를 활용하여 전체 key값과 value값을 구분지어 활용 및 출력할 수 있습니다.
일반적으로 key값만 사용하여 get(key)메소드에 활용함으로써 원하는 값을 찾는 경우가 많으므로 keySet()의 활용도가 높습니다. 하지만, key값을 이용하여 value를 찾는 과정에서 시간이 많이 소모되므로 많은 양의 데이터를 사용해야 한다면 entrySet()을 활용하는 것이 성능에 좋습니다.

### Iterator 활용
```java
import java.util.*;

HashMap<Integer, Integer> hashmap = new HashMap<>();

hashmap.put(1, 10);
hashmap.put(2, 20);

//entrySet().iterator()
Iterator<Entry<Integer, Integer>> entries = hashmap.entrySet().iterator();
while(entries.hasNext()){
    Map.Entry<Integer, Integer> entry = entries.next();
    System.out.println("Key:"+entry.getKey()+", Value:"+ entry.getValue());
}
//Key:1, Value:10
//Key:2, Value:20
		
//keySet().iterator()
Iterator<Integer> keys = hashmap.keySet().iterator();
while(keys.hasNext()){
    int key = keys.next();
    System.out.println("Key:" + key + ", Value:" +  hashmap.get(key));
}
//Key:1, Value:10
//Key:2, Value:20
```
보통 Array같은 형태를 전체 출력하기위해 반복문을 사용하는 경우가 많습니다. 하지만 HashMap은 Iterator를 활용하여 비교적 간편하게 출력할 수 있습니다.

---

### [마무리]
HashMap의 활용은 자주 했지만, 성능 적인 면에서 entrySet()이 더 낫다는 사실은 놀라웠습니다. 코딩테스트 문제를 연습하다보면 시간문제 또는 메모리 초과 문제를 자주 직면하게 됩니다. 이러한 문제들에 keySet()을 활용한 부분이 많았던 기억이 납니다. 해당 부분을 수정하여 더 효율적으로 문제를 수행할 수 있도록 노력하고자 합니다.
이후엔 정렬을 할 때 사용하는 Comparator에 대해 알아보고자 합니다.
코딩테스트 문제를 풀 때 HashMap 뿐만 아니라 다른 자료구조에도 정렬은 문제풀이에 필수적인 요소라고 할 수 있습니다. 이를 효과적으로 처리하는 Comparator 클래스에 대해 알아보겠습니다.

---

링크 : https://velog.io/write?id=29f096c2-2d7f-4a34-8ab4-c3224f4f0c05