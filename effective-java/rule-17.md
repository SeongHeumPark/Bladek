## 계승을 위한 설계와 문서를 갖추거나, 그럴 수 없다면 계승을 금지하라

### 왜?

- 무슨 일이 일어날지 모른다. _(재정의 메소드)_

### 효율적인 하위 클래스 작성할 수 있도록 하는 방법?

- 클래스 내부 동작에 개입할 수 있는 훅을 신중하게 고른 `protected` 메서드 형태로 제공해야 한다.
- 또는 `protected` 멤버 형태로 제공해야 한다.
- `protected` 멤버는 가능한한 수를 줄여야 하고 너무 적어서도 안된다. _(어쩌라는 겨...)_

### 계승을 위해 설계한 클래스의 테스트

- __유일무이__ 하위 클래스를 직접 만들어 보는 것
- 대체로 __3개__면 충분
- 상위 클래스를 구현한 사람과 __다른 사람__이 만들 것

### 계승 허용의 제약사항

- __생성자__는 재정의 가능 메서드를 호출해서는 안된다.
- `clone()`이나 `readObject()` 메서드 안에서 직/간접적인 재정의 가능한 메서드를 호출하지 않도록 주의한다.
