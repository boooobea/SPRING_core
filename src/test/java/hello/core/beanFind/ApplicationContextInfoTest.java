package hello.core.beanFind;

import hello.core.AppConfigBySpring;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigBySpring.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {

        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object obj = ac.getBean(beanName);
            System.out.println("name: " + beanName + ", obj: " + obj);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationFindBean() {

        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //bean metaData
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

            //ROLE_APPLICATION 직접 등록한 빈
            //ROLE_INFRASTRUCTURE 스프링 내부에서 사용하는 빈
            //if ( beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION ) {
            if ( beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE ) {
                Object bean = ac.getBean(beanName);
                System.out.println("name: " + beanName + ", obj: " + bean);
            }
        }
    }
}
