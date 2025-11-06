package hello.core.Autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

//자동주입 어노테이션 옵션테스트
public class AutowiredTest {

    @Test
    void autowiredTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false) //대상이없으면 호출이 안됨
        public void setNoBean1(Member noBean) {
            System.out.println("noBean1 : " + noBean);
        }

        @Autowired//대상이 없으면 null
        public void setNoBean2(@Nullable  Member noBean2) {
            System.out.println("noBean2 : " + noBean2);
        }

        @Autowired//
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 : " + noBean3);
        }
    }
}
