package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        /*
        basePackages = "hello.core.member",
        지정이없으면(default) @ComponentScan이 붙은 클래스의 패키지가 시작위치가 된다.
        하위 클래스는 모두 bean설정이 된다.
         */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
@Configuration
public class AutoAppConfig {

    // bean이 중복되어 충돌되었을 경우 수동이 자동을 엎어쓴다.
    /*
    @Bean(name = "memoryMemberRepository")
    MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
    */
}
