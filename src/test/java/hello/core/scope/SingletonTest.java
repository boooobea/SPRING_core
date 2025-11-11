package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(singletonBean.class);
        singletonBean singleton1 = ac.getBean(singletonBean.class);
        singletonBean singleton2 = ac.getBean(singletonBean.class);
        System.out.println("singleton1: " + singleton1);
        System.out.println("singleton2: " + singleton2);

        // 싱글톤은 두개가 같음
        Assertions.assertThat(singleton1).isSameAs(singleton2);
        ac.close();
    }

    @Scope("singleton")
    static class singletonBean{
        @PostConstruct
        public void init() {
            System.out.println("singletonBean.init");
        }
        @PreDestroy
        public void destroy() {
            System.out.println("singletonBean.destroy");
        }
    }
}
