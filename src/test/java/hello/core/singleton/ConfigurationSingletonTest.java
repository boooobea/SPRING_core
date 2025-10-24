package hello.core.singleton;

import hello.core.AppConfigBySpring;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigBySpring.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepositoryOrg = ac.getBean("memberRepository", MemberRepository.class);
        System.out.println("member origin = " + memberRepositoryOrg);

        MemberRepository memberRepository = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMmemberRepository();
        System.out.println("member1 : " + memberRepository);
        System.out.println("member2 : " + memberRepository2);

        Assertions.assertThat(memberRepository).isSameAs(memberRepository2);
        Assertions.assertThat(orderService.getMmemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigBySpring.class);

        AppConfigBySpring bean = ac.getBean(AppConfigBySpring.class);
        System.out.println("bean = " + bean);
        //bean = hello.core.AppConfigBySpring$$SpringCGLIB$$0@13518f37

    }
}
