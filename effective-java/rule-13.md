## 클래스와 멤버의 접근 권한은 최소화하라

### 왜?

- __정보 은닉 _(캡슐화)___을 위해서
- __정보 은닉__은 모듈 사이의 __의존성__을 낮춤
- __의존성__을 낮추면 여러 가지 좋아짐
  - 개발 속도, 테스팅, 최적화, 이해도, 유지보수 부담

### 원칙

- 각 클래스와 멤버는 가능한 한 접근 불가능하도록 만들어라

### 세부 원칙

- 객체 필드는 절대 `public`으로 선언하면 안 된다.
  - 왜? __다중 스레드에 안전하지 않아서__
- `public static final` 배열 필드를 두거나, 배열 필드를 반환하는 접근자를 정의하면 안 된다.

### 정리 및 느낀점

- 클래스와 멤버의 접근 권한을 최소화하면 좋은 일(?)들이 생긴다.
- `private`가 최고다??
- 사실 이 부분은 __Android 플랫폼__과는 조금 거리가 있는 얘기인 것 같다.
- 외부 라이브러리를 사용함으로 인해 위 부분이 깨지는 경우가 있다. _(ButterKnife)_