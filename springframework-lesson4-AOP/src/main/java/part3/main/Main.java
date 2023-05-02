package part3.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part3.config.ProjectConfig;
import part3.services.HelloService;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            HelloService service = context.getBean(HelloService.class);

            String message = service.hello("Gigi");

            System.out.println("Result is " + message + "!");
        }
    }
}