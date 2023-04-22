> 백기선님의 [코딩으로 학습하는 GoF의 디자인 패턴](https://www.inflearn.com/course/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard) 강의를 보고 실습한 내용입니다.  
> 강의에서 제공된 코드를 따라해보고, 제 방식으로 리팩토링을 진행했습니다.   
> README 에는 강의에서 설명한 내용, 여러 문서들, 제 생각이 섞여 있습니다.   
> ~저도 사람이기 때문에~ 정확하지 않은 정보가 있을 수 있습니다.  

# Table of contents

[A. 생성 패턴 (Creational Patterns)](#a-생성-패턴-creational-patterns)
* [A-1. 싱글톤 패턴 (Singleton)](#a-1-싱글톤-패턴-singleton)
* [A-2. 팩토리 메서드 패턴 (Factory method)](#a-2-팩토리-메서드-패턴-factory-method)
* [A-3. 추상 팩토리 패턴 (Abstract factory)](#a-3-추상-팩토리-패턴-abstract-factory)
* [A-4. 빌더 패턴 (Builder)](#a-4-빌더-패턴-builder)
* [A-5. 프로토타입 패턴 (Prototype)](#a-5-프로토타입-패턴-prototype)

[B. 구조 패턴 (Structual Patterns)](#b-구조-패턴-structual-patterns)
* [B-1. 어댑터 패턴 (Adapter)](#b-1-어댑터-패턴-adapter)
* [B-2. 브릿지 패턴 (Bridge)](#b-2-브릿지-패턴-bridge)
* [B-3. 컴포짓 패턴 (Composite)](#b-3-컴포짓-패턴-composite)
* [B-4. 데코레이터 패턴 (Decorator)](#b-4-데코레이터-패턴-decorator)
* [B-5. 퍼사드 패턴 (Facade)](#b-5-퍼사드-패턴-facade)
* [B-6. 플라이웨이트 패턴 (Flyweight)](#b-6-플라이웨이트-패턴-flyweight)
* [B-7. 프록시 패턴 (Proxy)](#b-7-프록시-패턴-proxy)

[C. 행동 패턴 (Behavioral Patterns)](#c-행동-패턴-behavioral-patterns)
* [C-1. 책임 연쇄 패턴 (Chain of responsibility)](#c-1-책임-연쇄-패턴-chain-of-responsibility)
* [C-2. 커맨드 패턴 (Command)](#c-2-커맨드-패턴-command)
* [C-3. 인터프리터 패턴 (Interpreter)](#c-3-인터프리터-패턴-interpreter)
* [C-4. 이터레이터 패턴 (Iterator)](#c-4-이터레이터-패턴-iterator)
* [C-5. 중재자 패턴 (Mediator)](#c-5-중재자-패턴-mediator)
* [C-6. 메멘토 패턴 (Memento)](#c-6-메멘토-패턴-memento)
* [C-7. 옵저버 패턴 (Observer)](#c-7-옵저버-패턴-observer)
* [C-8. 상태 패턴 (State)](#c-8-상태-패턴-state)
* [C-9. 전략 패턴 (Strategy)](#c-9-전략-패턴-strategy)
* [C-10. 템플릿 메서드 패턴 (Template method)](#c-10-템플릿-메서드-패턴-template-method)
* [C-11. 비지터 패턴 (Visitor)](#c-11-비지터-패턴-visitor)

<br/>

# A. 생성 패턴 (Creational Patterns)

## A-1. 싱글톤 패턴 (Singleton)

### 정의

인스턴스를 오직 한개만 만들어 제공하고, 1개임을 보장하는 클래스를 사용하는 패턴이다. 

<br/>

### 구현 방법1: private 기본 생성자 만들기

`new`를 사용해서 인스턴스를 만드는 것을 허용하면 안 된다.  
클래스 밖에서 `new`를 사용해서 인스턴스를 만드는 것을 불가능하게 하려면 private 기본 생성자를 만들면 된다.  
그리고 생성된 인스턴스에 global하게 접근할 수 있는 static 메서드를 만들어줘야 한다.  
해당 static 메서드의 이름은 `getInstance()` 라 가정하고, 호출하면 다음 과정을 진행한다.  

1. 해당 인스턴스가 이미 존재하는지 존재하지 않는지 판단한다.  
2. 존재하면 인스턴스를 반환하고, 존재하지 않는다면 생성 후 반환한다.  

하지만 이 방식은 멀티쓰레드 환경에서 안전하지 않다.   
쓰레드 별로 `getInstance()` 메서드 내에서 생성 로직을 각각 호출할 수도 있기 때문이다.  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings1.java)

<br/>

### 구현 방법2: `getInstance()` 메서드에 `synchronized` 키워드로 락 걸어주기

따라서 가장 쉬운 방법은 `synchronized` 키워드로 락을 걸어주는 방식이다.  
하지만 이 방식은 락을 거는 방식이기 때문에 성능 상 유리하지 않다.  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings2.java)

<br/>

### 구현 방법3: 이른 초기화(eager initialization) 사용하기

static 타입의 변수가 생성되는 시점에 인스턴스를 만들어서 대입해주는 방식이다.  
하지만 미리 만든다는 행위 때문에 단점이 될 수도 있다.  
만약 인스턴스의 생성 비용이 비싸다면 나중에 사용 시점에 만드는 것이 더 나은 선택일 수도 있다.  
자주 사용하는 인스턴스인 경우에만 이 방식으로 만드는 것이 좋다.  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings3.java)

<br/>

### 구현 방법4: Double checked locking 기법 사용하기

미리 만드는 것도 싫고, `synchronized` 를 사용해서 성능 저하도 피하고 싶다면 이 방법도 있다.  
인스턴스가 존재하는지 존재하지 않는지 판단 후 인스턴스 생성 시점에만 `synchronized` block을 사용해서 동기화 하는 방법이다.  
추가적으로 인스턴스 변수 선언 시 `volatile` 키워드를 추가해서 메모리의 데이터를 직접적으로 read/write 하도록 해야만 안전하게 사용 가능하다. (jdk 1.5~)  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings4.java)

<br/>

### 구현 방법5: static inner 클래스 사용하기

방법3에서 소개했던 이른 초기화 방식과 유사하다. 이른 초기화를 클래스의 멤버 변수로 진행하는 것이 아니라 static inner 클래스에서 진행하도록 한다.  
그러면 `getInstance()` 메서드가 호출되는 시점에 초기화가 진행되면서 안전하게 처리할 수 있다.  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings5.java)

<br/>

> 싱글턴 인스턴스를 만드는 5가지 방법에 대해 알아봤다.    
> 그럼에도 불구하고 싱글턴을 깨트리는 방법이 존재한다. 깨트리는 방법에 대해 알아보자.    

### 깨트리는 방법1: Reflection 사용하기

Java의 바이트 코드를 조작해서 인스턴스의 제어권을 뺏어버리는 방법이다.  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/BreakSingletonWithReflection.java)

<br/>

### 깨트리는 방법2: 직렬화 & 역직렬화 사용하기

직렬화 가능한 클래스로 사용하기 위해서는 `Serializable` 인터페이스를 구현해야 한다.  
역직렬화 과정에서 반드시 `readResolve()` 메서드를 찾아서 실행하게 되는데, 원래는 `new XXX()`가 실행된다.  
하지만 여기서 `getInstance()` 를 호출하도록 하면 역직렬화 과정에서 싱글턴이 깨지는 문제를 해결할 수 있다.  

:octocat: [**Example code 1**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings5.java)
:octocat: [**Example code 2**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/BreakSingletonWithSerializable.java)

<br/>

> 각 방식에 장단점이 있어 보인다. 권장하는 방법은 뭘까?

### 권장 방법: enum 사용하기

싱글턴을 깨는 2가지 방법에 대해 알아봤는데, 역직렬화를 사용하는 방법은 `readResolve()` 메서드를 명시적으로 구현해서 예방할 수 있었다.    
하지만 리플렉션을 사용하는 방법은 해결할 수 없었다.  
이 경우에는 enum을 사용하면 깨지지 않는 완전한 싱글턴을 보장한다.  
단점을 꼽아보자면, 미리 만들어진다는 점과 상속 기능을 사용하지 못한다는 것이다.  

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/singleton/Settings6.java)

<br/>

### 자바와 스프링에서 활용 예시

- java.lang.Runtime 객체
- ApplicationContext 레벨에서 관리되는 빈 객체 (Singleton-Scope)
- 다른 디자인 패턴(빌더, 퍼사드, 추상 팩토리 등) 구현체의 일부로 쓰이기도 함

<br/>

### 더 읽어보기

- https://velog.io/@backfox/싱글톤-패턴을-경계하는-사람들의-이야기

<br/>

## A-2. 팩토리 메서드 패턴 (Factory method)

### 정의

구체적으로 어떤 타입의 인스턴스를 만들지는 서브 클래스가 결정하는 패턴이다.  
다양한 구현체(Product)가 있고, 그 중에서 특정한 구현체를 만들 수 있는 다양한 팩토리(Creator)를 제공할 수 있다.

<br/>

### 장점: 팩토리 메서드 패턴을 사용하면 OCP 원칙을 살리기 편하다.

> "확장에 열러있고, 변경에 닫혀있다!"

예시를 봤을 때, 원래는 `WhiteShip` 만 만들었었는데 `BlackShip`도 만들고 싶다.   
- `WhiteShip` 관련 코드에는 변경이 생기지 않고 -> "변경에 닫혀있다"   
- `BlackShip` 관련 코드를 추가할 수 있다. -> "확장에 열려있다"   
  
어떤 인스턴스를 만들기 위해 필요한 로직에 변경 없이 새로운 인스턴스를 다른 방법으로 얼마든지 확장할 수 있게 된다.  
생성할 인스턴스(Product)와 그 인스턴스를 생성하는 팩토리(Creator)의 커플링을 느슨하게 만들었기 때문에 가능하다.

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/tree/main/src/main/java/me/study/gofdesignpattern/creational_patterns/factory_method/_02_after)

<br/>

### Java 버전 별 구현 특징

Java 8에 추가된 default 메서드와 Java 9에 추가된 private 메서드를 사용할 수도 있다.  
일반적으로 Java 11을 사용한다면 인터페이스에 default 메서드와 private 메서드를 사용해서 편하게 팩토리 메서드 패턴을 사용할 수 있겠지만,
Java 8버전 등을 사용한다면 Abstract class를 인터페이스와 구현 클래스 사이에 추가해서 팩토리 메서드 패턴을 사용할 수 있다.  

<br/>

### 단점: 코드가 많아진다.

각자 역할에 따라 클래스와 인터페이스를 만들다 보니 절대적인 코드의 양이 많아질 수 있다.  
코드가 많아지면 관리해야 할 포인트가 늘어남을 의미한다.  

<br/>

### 자바와 스프링에서 활용 예시

- 단순한 팩토리 메서드 패턴
  - 매개변수 값에 따라, 메서드에 따라 각기 다른 인스턴스를 반환하는 단순한 버전의 팩토리 패턴
  - java.lang.Calender / java.lang.NumberFormat
- 스프링의 BeanFactory
  - Object 타입의 Product 를 만드는 BeanFactory 라는 Creator

<br/>

## A-3. 추상 팩토리 패턴 (Abstract factory)

### 정의

서로 관련있는 여러 객체를 만들어주는 인터페이스를 활용하는 패턴이다.

<br/>

### 장점

클라이언트 측에서 구체적으로 어떤 클래스의 인스턴스(concrete product)를 사용하는지 감출 수 있다.
따라서, 구체 클래스가 변경되더라도 코드 변경이 발생하지 않는다.

:octocat: [**Example code**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/abstract_factory/_02_after/ShipInventory.java)

<br/>

### 팩토리 메서드 패턴과의 차이점

구체적인 인스턴스를 구체적인 팩토리로 만드는 것 까지는 동일하지만,
인스턴스를 생성하는 주체가 클라이언트 측에 있는 것이 추상 팩토리 패턴의 특징이다.
  
조금 더 자세히 말해서,  
구현 형태와 효과는 비슷하다. 둘 다 객체 생성 과정을 추상화한 인터페이스를 제공한다.  
  
하지만 서로 관점이 조금 다르다.  
- 팩토리 메서드 패턴은 "팩토리를 구현하는 방법(inheritance)"에 초점을 둔다.
- 추상 팩토리 패턴은 "팩토리를 사용하는 방법(composition)"에 초점을 둔다.
  
목적도 조금 다르다.  
- 팩토리 메서드 패턴은 구체적은 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적이다.
- 추상 팩토리 패턴은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적이다.

<br/>

### 자바와 스프링에서 활용 예시

- Java 라이브러리
  - javax.xml.xpath.XPathFactory#newInstance()
  - javax.xml.transform.TransformerFactory#newInstance()
  - javax.xml.parsers.DocumentBuilderFactory#newInstance()
- Spring
  - FactoryBean 과 그 구현체들

:octocat: [**Example code 1**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/abstract_factory/_03_java/DocumentBuilderFactoryExample.java)
:octocat: [**Example code 2**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/abstract_factory/_03_java/FactoryBeanExample.java)

<br/>

## A-4. 빌더 패턴 (Builder)

### 정의

동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법이다.

<br/>

### 장점

- 객체 생성에 대해 다양한 요구사항을 유연하게 반영할 수 있다.
- 객체 생성 과정에서 필요에 따라 강제할 수 있어서 불완전한 객체의 생성을 예방할 수 있다.
- 빌더를 통해서 반복적인 생성 로직이 필요한 경우라면 빌더를 의존하는 디렉터(Director)를 사용할 수 있다.
  - 클라이언트에서 디렉터를 사용하면 반복적인 생성 로직을 깔끔하고 안전하게 사용할 수 있다.
- 복잡한 객체를 만드는 구체적인 과정을 숨길 수 있다.

<br/>

### 단점

- 인스턴스 생성을 위해 빌더 인터페이스를 만들어야 하고, 디렉터도 만들어야 한다. 
  - 요구사항의 최소 조건에 비해 많은 객체가 생성되어야 한다.
- 많은 객체가 생성되고 활용하면서, 인스턴스 생성 로직이 조금 복잡해진다. (대부분 디자인 패턴의 단점)

<br/>

### 자바와 스프링에서 활용 예시

- Java 8 Stream.Builder API
- StringBuilder
- Lombok 의 @Builder
- Spring
  - UriComponentBuilder
  - MockMvcWebClientBuilder
  - XXXBuilder ...

:octocat: [**Example code 1**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/builder/_03_java/StreamExample.java)
:octocat: [**Example code 2**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/builder/_03_java/LombokExample.java)

<br/>

## A-5. 프로토타입 패턴 (Prototype)

### 정의

기존 인스턴스를 복제해서 새로운 인스턴스를 만드는 패턴이다.    
복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용해 새 인스턴스를 만들 수 있다.  
  
예를 들어, 인스턴스 하나를 만드는 데 DB Connection이 필요하거나 네트워크 통신을 통해 
가져온 값을 기반으로 만들어지는 객체라면 인스턴스 하나를 만드는 비용이 비쌀 것이다. 
이러한 경우에 미리 DB 혹은 네트워크 통신을 거친 후 프로토타입을 하나 만들어두고, 
프로토타입으로부터 모든 데이터를 복제해서 필요한 값만 수정하는 방식으로 인스턴스를 생성하면 
불필요한 리소스 낭비를 줄일 수 있다.

<br/>

### Java의 Object.clone()

복제하는 기능은 Java의 Object 클래스에 포함된 clone() 메서드를 활용한 매커니즘을 따라간다. 
하지만 clone() 기능은 protected 이기 때문에 일반적으로 호출할 수 없다. 따라서 복제 기능이 필요한 
클래스에는 Cloneable 인터페이스를 구현해야 한다.

<br/>

### Shallow copy와 Deep copy

Object 의 clone() 을 사용하면 기본적으로 Shallow copy로 동작한다. 기본적으로 복제 기능이 동작할 때 
field-for-field 방식으로 복제된다. 그 과정에서 primitive type 을 제외하고 reference type 들은 
reference 값들만 복제가 된다. 따라서 프로토타입에서 가리키는 인스턴스와 복제본에서 가리키는 
인스턴스는 동일하다.

<br/>

### 장점

- 복잡한 객체를 만드는 과정을 숨길 수 있다.
- 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 비용(시간 또는 메모리)적인 면에서 효율적일 수도 있다.
- 추상적인 타입을 리턴할 수 있다.

<br/>

### 단점

- 복잡한 객체를 만드는 과정 자체가 복잡할 수 있다.
  - 동일한 객체를 만들어 줘야 하는데, 객체 간 순환 참조가 있는 경우에는 과정이 복잡할 수 있다.

<br/>

### 자바와 스프링에서 활용 예시

- 명시적으로 프로토타입 패턴을 사용할 일은 잘 없다.
- ArrayList 의 내용을 복제할 때 ArrayList의 생성자를 사용해서 Copy 가능하다.
- ModelMapper, MapStruct 등의 라이브러리를 사용해서 값 매핑이 가능하다.

:octocat: [**Example code 1**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/prototype/_03_java/JavaCollectionExample.java)
:octocat: [**Example code 2**](https://github.com/JinseongHwang/gof-design-pattern/blob/main/src/main/java/me/study/gofdesignpattern/creational_patterns/prototype/_03_java/ModelMapperExample.java)

<br/>
<br/>

# B. 구조 패턴 (Structual Patterns)



## B-1. 어댑터 패턴 (Adapter)

## B-2. 브릿지 패턴 (Bridge)

## B-3. 컴포짓 패턴 (Composite)

## B-4. 데코레이터 패턴 (Decorator)

## B-5. 퍼사드 패턴 (Facade)

## B-6. 플라이웨이트 패턴 (Flyweight)

## B-7. 프록시 패턴 (Proxy)

# C. 행동 패턴 (Behavioral Patterns)

## C-1. 책임 연쇄 패턴 (Chain of responsibility)

## C-2. 커맨드 패턴 (Command)

## C-3. 인터프리터 패턴 (Interpreter)

## C-4. 이터레이터 패턴 (Iterator)

## C-5. 중재자 패턴 (Mediator)

## C-6. 메멘토 패턴 (Memento)

## C-7. 옵저버 패턴 (Observer)

## C-8. 상태 패턴 (State)

## C-9. 전략 패턴 (Strategy)

## C-10. 템플릿 메서드 패턴 (Template method)

## C-11. 비지터 패턴 (Visitor)
