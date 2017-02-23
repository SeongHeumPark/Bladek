## `public` 클래스 안에는 `public` 필드를 두지 말고 접근자 메서드를 사용하라

### 왜?

```java
class Point {
	public double x;
	public double y;
}
```

- 데이터 필드 직접 조작 가능
- __캡슐화__의 이점을 누릴 수 없다.
- API를 변경하지 않고서는 내부 표현을 변경할 수 없음
- __불변식__을 강제할 수 없음
- 필드를 사용하는 순간에 어떤 동작이 실행되도록 할 수 없음

### 느낀점

- ㅇㅈ? ㅇㅇㅈ ㅇㄱㄹㅇ ㅂㅂㅂㄱ