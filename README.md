# 스프링 핵심원리 


### 1. 스프링 원리 이해 - 예제 
### 2. 스프링 원리 이해 - 객체지향원리 적용
### 3. 스프링컨테이너, 빈
### 4. 싱글톤
### 5. 컴포넌트스캔
### 6. 의존관계주입(DI)
- 생성자 주입(누락방지)

    의존 관계 주입은 앱 종료시까지 변경할 일이 없어서 객체를 생성할 때 한번만 호출되는 생성자 주입이 좋다. 
    
    수정자 주입은 메서드를 public으로 열어두어야 한다는 점이 번거롭다.

- final(불변)

    생성자에 final키워드를 넣어서 값을 꼭 세팅되도록 하자. 불변 객체를 만들 수 있다.

  > 생성자 주입 > (옵션이 필요한 경우) 세터 주입 > (권장하지 않음) 필드 주입


- 생성자 옵션 

    `@Autowired(Requied = false)` 값이 없으면 실행하지 않는다. 

    `@Nullable` 값이 없으면 null 반환

    `@Optional<?>` 값이 없으면 Optional.empty 반환


- Lombok

  Preferences Annotation Processors 검색 Enable annotation processing 체크 

  Getter,Setter, ToString, RequiredArgsConstructor(필수값에 대한 생성자를 생성)


- 빈 매칭

    `@Autowired` 타입 매칭인데 여러 개의 빈이 발견 됐을때 이름으로 추가 매핑한다.

    `@Qualifier` 빈 등록시, 빈 주입시 동일하게 사용한다. (헷갈리면 사용하지 말것)

    `@Primary` 우선 순위로 지정된다.

    > `@Qualifier`는 자세하게 /`@Primary`는 기본으로 세팅되기 때문에 둘 다 사용할 경우 자세한것이 우선권을 가짐


- 어노테이션(옵션)
    
    어노테이션은 상속이 없기 때문에 사용자정의로 만들어서 사용 `@MainDiscountPolicy` 참고


-  빈이 필요한 경우(옵션)

    `AllBeanTest` 참고 

### 7. 빈 생명주기

- 스프링 컨테이너 생성 -> **스프링 빈 생성** -> 의존관계 주입 -> **초기화 콜백** -> 사용 -> **소멸 전 콜백** -> 소멸, 종료  

1. `InitializingBean`, `DisposableBean`

    스프링 전용 인터페이스로 코드가 인터페이스에 의존한다.

    코드를 고칠 수 있는 라이브러리에 적용할 수 없다.


2. `@Bean(initMethod = "init", destroyMethod = "close")` 

    메서드 이름을 자유롭게 줄 수 있다. 

    스프링 빈이 스프링 코드에 의존하지 않는다.

    설정정보이기 때문에 코드를 고칠 수 없는 라이브러리에도 적용 가능! 


3. `@PostConstruct`, `@PreDestroy`

    스프링에서 권장하는 방법. 스프링에 종속된 기술이 아닌 자바 표준 기술

    외부 라이브러리에는 적용하지 않는다. 

### 8. 빈 스코프 

스프링 컨테이너는 프로토타입 빈을 생성, 의존관계 주입, 초기화까지만 처리한다.

`singleton` 기본타입, 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 스코프

`protoType` 프로토타입의 빈의 생성, 의존관계 주입까지만 하는 짦은 범위의 스코프

- `ObjectProvider`

    `prototypeBeanProvider.getObject()`스프링 컨테이너를 통해 해당 빈을 찾아서 반환한다.(**DL**)

    - `ObjectFactory` 기능단순, 스프링에 의존 

    - `ObjectProvider` `ObjectFactory`상속으로 옵션, 스트림 처리 등 편의기능이 많고 스프링에 의존


- `javax.inject.Provider.Provider`

    스프링이 아닌 다른 컨테이너에서 사용한다. 


Web scope 
- `requst` 웹 요청이 들어오고 나갈때 까지, 각각의 HTTP 요청마다 별도로 생성
    
    - `@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)` 상속된 가짜 프록시 객체를 생성하여 의존관계에 주입한다. 
    - 원본이 아니지만 동일하게 사용할 수 있다. 즉 다형성의 성질 
    - 일단 의존 주입이 되고 실제로 필요한 시점까지 지연된다는 점이 강점이다. 

- `session` 웹 세션이 생성되고 종료될때 까지

- `application` 웹의 서블릿 컨텍스트와 같은 생명주기


    - 