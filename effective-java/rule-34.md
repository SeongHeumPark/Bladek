## 확장 가능한 `enum`을 만들어야 한다면 인터페이스를 이용하라

### 왜?

- `enum` 자료형은 실질적으로 `final`로 선언된 것과 마찬가지다. (규칙 30)
- 즉, __객체 생성__, __계승 확장__이 불가능 (규칙 30)

### 인터페이스를 이용한 확장 가능한 `enum` 자료형

```java
public interface Operation {
	double apply(double x, double y);
}

public enum BaseOperation implements Operation {
	PLUS("+") {
    	public double apply(double x, double y) {
        	return x + y;
    	}
	}

	// 이하 생략
}

public enum ExtendedOperation implements Operation {
	EXP("^") {
    	public double apply(double x, double y) {
        	return Math.pow(x, y);
    	}
	}

	// 이하 생략
}

public static void main(String[] args) {
	double x = Double.parseDouble(args[0]);
	double y = Double.parseDouble(args[1]);

	// 한정적 자료형 토큰 사용
	test(ExtendedOperation.class, x, y);
	// 한정적 와일드카드 자료형 사용
	test(Arrays.asList(ExtendedOperation.values()), x, y);
}

// 한정적 자료형 토큰 사용
public static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
	for (Operation op : opSet.getEnumConstants()) {
    	System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}

// 한정적 와일드카드 자료형 사용
public static void test(Collection<? extends Operation> opSet, double x, double y) {
	for (Operation op : opSet) {
    	System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}
```

### 정리

- 인터페이스를 이용하면 계승한 것처럼 흉내낼 수 있다.

### 의문점

- 이 책에서 얘기하는 "__자료형__을 나타낼 때만 __인터페이스__를 사용하라." 를 어기지 않는가?