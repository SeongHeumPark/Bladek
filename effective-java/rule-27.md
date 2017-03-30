## 가능하면 제네릭 메서드로 만들 것

### 왜?

- 제네릭 클래스와 같은 이유

### 사용법

- 형인자를 선언하는 형인자 목록은 메서드의 수정자와 반환값 자료형 사이에 둔다.

  ```java
  public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
  	Set<E> result = new HashSet<>(s1);
  	result.addAll(s2);

  	return result;
  }
  ```

### 자료형 유추

```java
public static void main(String[] args) {
	Set<String> guys = new HashSet<>(Arrays.asLast("Tom", "Dick", "Harry"));
	Set<String> guys = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
	Set<String> aflCio = union(guys, stooges);

	System.out.println(aflCio);
}
```

- 제네릭 생성자를 호출할 때는 명시적으로 주어야 했던 형인자를 전달할 필요가 없다.

### 제네릭 팩터리 메서드

- 중복되는 형인자를 제거하기 위해 사용
- 1.7부터 `<>`연산자

### 제네릭 싱글턴 패턴

- 싱글턴인데 많은 자료형에 적용하고 싶은 경우 사용

  ```Java
  public interface UnaryFunction<T> {
  	T apply(T arg);
  }

  private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<>() {
  	public Object apply(Object args) {
      	return args;
  	}
  }

  // IDENTITY_FUNCTION은 무상태 객체고 형인자는 비한정적 인자이므로
  // 모든 자료형이 같은 객체를 공유해도 안전하다.
  @SuppressWarning("unchecked")
  public static <T> UnaryFunction<T> identityFunction() {
  	return (UnaryFunction<T>) IDENTITY_FUNTION;
  }
  ```

### 재귀적 자료형 한정

- 형 인자가 포함된 표현식으로 형 인자를 한정하는 것

- `Comparable` 클래스가 대표적

  ```Java
  public interface Comparable<T> {
  	int compareTo(T o);
  }

  // 리스트의 최대 값 반환
  // 재귀적 자료형 한정을 통해 상호 비교 가능성 표현
  public static <T extends Comparable<T>> T max(List<T> list) {
  	Iterator<T> i = list.iterator();
  	T result = i.next();

  	while (i.hasNext()) {
      	T t = i.next();
      
      	if (t.compareTo(result) > 0) {
          	result = t;
      	}
  	}

  	return result;
  }
  ```

### 정리

- 제네릭 클래스 때와 같음