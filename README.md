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

    final(불변)

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



### 7. 빈 생명주기
### 8. 빈 스코프 
