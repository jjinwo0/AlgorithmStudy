#### 시작하기에 앞서...
코딩테스트 문제를 풀다보면 배열, 리스트 등 컬렉션에 대한 탐색을 위해 정렬 작업을 선행하는 경우가 많습니다. 일반적인 배열의 경우 Arrays.sort()를 활용하여 정렬하게되며, 리스트는 Collections.sort()를 활용하여 정렬합니다. 하지만, 해당 작업들은 default로 사용할 경우 사용자가 직접 순서를 결정하지 못하고 오름차순으로 정렬됩니다. 우리가 만약 순서를 조작하여 정렬 작업을 하고자 할 경우, 특별한 작업이 추가되어야 하며, 저 또한 이런 경우에 어떻게 해결해야할지 어려움을 겪었던 경우가 종종 있습니다. 따라서 이러한 경우 사용할 "Comparator"에 대해 알아보고자 합니다.

---

## Comparator란?
> 객체 간 값의 비교를 위해 필요한 메서드를 정리한 인터페이스

Comparator는 사용자 정의 객체를 사용하거나 클래스 내에서 비교 메서드를 구현하고자 할 때, 또는 본인만의 다른 비교방식을 사용하고자 할 때 사용합니다.
```java
public interface Comparator<T>{
	int compare(T o1, T o2);
}
```
Comparator 인터페이스를 상속받게되면, 반드시 compare함수를 Override 해줘야 합니다.
Comparator의 compare함수는 인자값 두 개가 필요하며, 이를 대소비교하여 정렬 작업을 처리하게 됩니다.
선행인자와 후행인자를 연산하여 양수값을 반환하면 내림차순, 음수값을 반환하면 오름차순으로 순서가 정해지게 됩니다.

---

## Comparator 활용
이전에 코딩테스트 연습에 자주 활용하는 HashMap에 대해 포스팅하였습니다. 따라서 일반적인 List뿐만 아니라 HashMap으로는 어떻게 Comparator를 사용하는지 코드 및 실행 결과로 활용법을 알아보도록 하겠습니다.

```java
import java.util.*;

class codingtest.Week5.Main {
    public static void main(String[] args) {

        System.out.println("[List만 활용]");

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(30);

        System.out.println("=== 오름차순 정렬 ===");

        Collections.sort(list); // 오름차순 정렬

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("=== 내림차순 정렬 ===");

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1; // 양수 값 return -> 내림차순
            }
        });

        Iterator<Integer> iter2 = list.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }

        System.out.println();
        System.out.println("[HashMap과 List 활용]");
        System.out.println("=== Key값을 기준으로 오름차순 정렬 ===");

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(1, 10);
        map.put(3, 50);
        map.put(5, 30);

        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());

        Collections.sort(keyList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2; // 음수 값 return -> 오름차순
            }
        });

        Iterator<Integer> keyIter = keyList.iterator();
        while(keyIter.hasNext()){
            Integer key = keyIter.next();
            System.out.println("key: " + key + ", value: " + map.get(key));
        }

        System.out.println("=== Value값을 기준으로 내림차순 정렬 ===");

        ArrayList<Integer> valueList = new ArrayList<>(map.values());

        Collections.sort(valueList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1; // 양수 값 return -> 내림차순
            }
        });

        Iterator<Integer> valIter = valueList.iterator();
        while(valIter.hasNext()){
            System.out.println("value: " + valIter.next());
        }

    }
}
```

### 출력 결과
![](https://velog.velcdn.com/images/jjinwo0/post/c9f9cbc8-d25e-41db-b8a2-36231223bdd4/image.png)
위와 같이 Comparator 인터페이스 안의 compare 메소드를 사용하여 담긴 값의 대소를 뺄셈 연산으로 결과 값을 반환하여 확인하고, 이를 통해 내림차순과 오름차순을 정하게 되는 구조입니다.
이전부터 사용은 했지만 매번 비교값 연산을 통한 오름차순과 내림차순에 대해 어떤 기준에서 이것이 정해지는가에 대해 헷갈림이 많았습니다. 이번 포스팅을 바탕으로 비교 메소드에 대한 이해도를 가지고 사용할 수 있을 것 같습니다.

### 글을 마치며
다음 기회엔 다른 비교 메소드인 Comparable 인터페이스에 있는 람다식을 활용한 compareTo() 메소드와 람다를 조금 더 편리하게 표기하는 더블콜론(::)에 대한 포스팅을 하고자 합니다.

--- 

링크 : https://velog.io/write?id=ac1672f7-dccd-4036-aaa8-d3931b093b65