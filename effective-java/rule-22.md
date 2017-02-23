## 멤버 클래스는 가능하면 static으로 선언하라

### 왜?

- 바깥 객체에 대한 참조를 유지 → __시간, 공간 요구량 증가__
- 바깥 객체에 대한 참조를 유지 → __바깥 객체에 대한 쓰레기 수집이 힘들어 짐__
- 바깥 객체 없이는 생성할 수 없음

### 중첩 클래스 종류

- 정적 멤버 클래스
- 비-정적 멤버 클래스
- 익명 클래스
- 지역 클래스

### 정적 멤버 클래스

- 가장 간단한 중첩 클래스

- `public` helper class

- `enum`이나 __Builder 패턴__의 `Builder` 클래스

  ```java
  public class Product {
  	private final String name;
  	// 이하 생략

  	public static class Builder {
  		private String name = null;
  		// 이하 생략

  		public Builder name(String name) {
  			this.name = name;
  			return this;
  		}
  		// 이하 생략
  	
  		public Product build() {
  			return new Product(this);
  		}
  	}

  	private Product() {
  	}

  	public Product(Builder builder) {
  		this.name = builder.name;
  	}
  	// 이하 생략
  }
  ```

### 비-정적 멤버 클래스

- __어댑터__를 정의할 때 많이 쓰임

- `Iterator` 클래스가 대표적인 예

  ```java
  public class MySet<E> extends AbstractSet<E> {
  	// 생략

  	public Iterator<E> iterator() {
  		return new MyIterator();
  	}

    	private class MyIterator implements Iterator<E> {
  		// 생략
    	}
  }
  ```

### 익명 클래스

- __함수 객체__

- 사용하는 순간 __선언 & 객체 생성__

- 여러 __제약 사항__
  - 비-정적 문맥일 때 바깥 객체를 가질 수 있음
  - 정적 문맥에서 아용해도 `static`멤버를 가질 수 없음
  - `instance of` 키워드를 사용할 수 없음
  - 여러 인터페이스를 구현하는 익명 클래스는 선언할 수 없음
  - 인터페이스를 구현하는 동시에 계승하는 익명 클래스를 선언할 수 없음

- 10줄 이하로 짧게 작성할 것 → __가독성__과 직결

  ```java
  Arrays.sort(stringArray, new Compartor<String>() {
  	public int compare(String s1, String s2) {
  		return s1.length() - s2.length;
  	}
  });
  ```

### 지역 클래스

- 사용 빈도가 __가장 낮음__

- 멤버 클래스처럼 __이름을 가짐__

- 반복적 사용 __가능__

- 비-정적 문맥에서 정의했을 때만, 바깥 객체를 가짐

- `static` 멤버는 가질 수 없음

- 익명 클래스처럼 짧게 작성해야 함

  ```java
  public class A {
  	// 생략
  	public void printLocal() {
  		class Local {
  			// 생략
  		}
  	
  		Local local = new Local();
  		System.out.print(local.toString());
  	}
  }
  ```

### 정리

- 객체 각각이 바깥 객체에 대한 참조를 가져야하는 경우: __비-정적 멤버 클래스__
- 그렇지 않은 경우: __정적 멤버 클래스__
- 특정 메소드에 속해야 하고, 
  오직 한 곳에서만 객체를 생성하며, 
  특성을 규정하는 자료형이 이미 있는 경우: __익명 클래스__
- 그렇지 않은 경우: __지역 클래스__