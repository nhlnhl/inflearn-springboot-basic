package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class BeanDefinitionTest {

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitonNames = ac.getBeanDefinitionNames();
        for (String beanDefinitonName : beanDefinitonNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitonName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitonName = " + beanDefinitonName + " beanDefinition = " + beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("빈 설정 메타정보 확인 - XML")
    void findApplicationBeanXML() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        String[] beanDefinitonNames = ac.getBeanDefinitionNames();
        for (String beanDefinitonName : beanDefinitonNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitonName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitonName = " + beanDefinitonName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
