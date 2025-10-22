package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        // 1.
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // 2. spring Annotation
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigBySpring.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "aaaaa", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new Member : " + member.getName());
        System.out.println("findMember : " + findMember.getName());

    }
}
