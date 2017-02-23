## 변경 가능성을 최소화하라

### 왜?

- 단순
- 스레드에 안전
- 동기화 불필요
- 자유롭게 공유 가능 _(= __방어적 복사본__을 만들 필요 없음)_

### 변경 불가능 클래스

- 객체를 수정할 수 없는 클래스
- 객체가 생성될 때만 내부 정보가 주어짐
- 객체가 살아 있을 때만 보존

### 변경 불가능 클래스를 만드는 이유

- 설계하기 쉽고
- 사용하기 쉽고
- 오류 가능성 적고
- 안전함

### 변경 불가능 클래스를 만드는 __다섯 규칙__

1. 객체 상태를 변경하는 메서드를 제공하지 않는다.
2. 계승할 수 없도록 한다.
3. 모든 필드를 `final`로 선언한다.
4. 모든 필드를 `private`로 선언한다.
5. 변경 가능 컴포넌트에 대한 독점적 접근권을 보장한다.
   독점적 접근권: 생성자 같이 유일하게 `final` 필드를 초기화할 수 있는 것

### 변경 불가능 클래스의 장점

- 내부도 공유할 수 있다.
- 다른 객체의 구성 요소로도 훌륭하다.

### 변경 불가능 클래스의 단점

- 값마다 별도의 객체를 만들어야 한다.

### 정리

- 변경 가능한 클래스로 만들 타당한 이유가 없으면 반드시 변경 불가능 클래스로 만들어라.
- 변경 불가능한 클래스로 만들 수 없다면, 변경 가능성을 최대한 제한하라.
- 특별한 이유가 없다면 모든 필드는 `final`로 선언하라.