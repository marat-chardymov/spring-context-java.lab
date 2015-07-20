import org.shop.config.RootAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Razor on 7/18/2015.
 */
public class TestSpringContext {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RootAppConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
