package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatusfulServiceTest {

    @Test
    void statusfulServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatusfulService service1 = ac.getBean(StatusfulService.class);
        StatusfulService service2 = ac.getBean(StatusfulService.class);

        //Thread 1
        int userAPrice = service1.order("userA", 10000);
        //Thread 2
        int userBPrice = service2.order("userB", 2000);

        //Thread 1 조회
        //int price1 = service1.getPrice();
        System.out.println(userAPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig {

        @Bean
        public StatusfulService statusfulService() {
            return new StatusfulService();
        }

    }
}