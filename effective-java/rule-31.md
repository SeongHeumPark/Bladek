### `ordinal()` 대신 객체 필드를 사용하라

### 왜?

- `EnumSet`과 `EnumMap`과 같은 `enum` 기반 자료구조를 위한 함수

### 해결책

- 객체 필드를 이용하라

  ```Java
  public enum Ensemble {
  	SOLO(1),
  	DUET(2),
  	TRIO(3),
  	QUARTET(4),
  	// ...
  	;

  	private final int numberOfMusicians;

  	Ensemble (int size) {
      	this.numberOfMusicians = size;
  	}

  	public int numberOfMusicians() {
      	return numberOfMusicians;
  	}
  }
  ```


### 정리

- `ordinal()`은 없다고 생각하자.