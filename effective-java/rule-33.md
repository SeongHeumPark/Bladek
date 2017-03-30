## `ordinal()`을 배열 첨자로 사용하는 대신 `EnumMap`을 이용하라

### 왜?

- 규칙 31, 32와 같음

### 아래 코드에 문제점은?

```Java
class Herb {
	enum Type { ANNUAL, PERENNIAL, BIENNIAL	}

	final String name;
	final Type type;

	Herb(String name, Type type) {
    	this.name = name;
    	this.type = type;
	}

	@Override
	public String toString() {
    	return name;
	}
}

public class Test {
	public static void main(String[] args) {
    	Herb[] garden = ... ;
    
    	Set<Herb>[] herbsByType =
        			(Set<Herb>[]) new Set[Herb.Type.values().length];
    
    	for (int i = 0; i < herbsByType.length; i++) {
        	herbsByType[i] = new HashSet<Herb>();
    	}
    
    	for (Herb h : graden) {
        	herbsByType[h.type.ordinal()].add(h);
    	}
    
    	// 결과 출력
    	for (int i = 0; i < herbsByType.length; i++) {
        	System.out.println("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
    	}
	}
}
```

- __배열__은 __제네릭__과 호환되지 않음 (무점검 형변환 필요)
- 배열 원소를 참조할 때, 정확한 int 값이 사용될지 보장할 수 없음 (`enum`의 `ordinal()` 때문)
  운 좋으면 `ArrayIndexOutOfBoundsException`

### 대안 `EnumMap`

- `EnumMap`은 `enum`을 __키__로 가지는 `Map`

```java
// EnumMap을 사용
public class Test {
	public static void main(String[] args) {
    	Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<>(Herb.Type.class);
    
    	for (Herb.Type t : Herb.Type.values()) {
        	herbsByType.put(t, new HashSet<>());
    	}
    
    	for (Herb h : graden) {
        	herbsByType.get(h.type).add(h);
    	}
    
    	System.out.println(herbsByType);
	}
}
```

### 다른 예제 `Phase` 클래스

- `EnumMap`을 중첩하여 사용 (공간 복잡도까지 고려됨)
- 자세한 내용은 책 p.219 참고

### 정리

- `ordinal()`은 배열 첨자로 사용하지 마라.
- `EnumMap`을 사용하라.