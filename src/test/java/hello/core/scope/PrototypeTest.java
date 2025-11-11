package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean protoType1 = ac.getBean(PrototypeBean.class);
        System.out.println("find protoType1");
        PrototypeBean protoType2 = ac.getBean(PrototypeBean.class);
        System.out.println("find protoType2");
        System.out.println("protoType1: " + protoType1);
        System.out.println("protoType2: " + protoType2);

        // 프로토타입은 두개가 다름
        Assertions.assertThat(protoType1).isNotSameAs(protoType2);
        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        // 프로토타입은 초기화까지만 관여하기 때문에 종료는 관여하지 않는다.
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
