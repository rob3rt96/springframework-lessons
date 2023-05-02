package part1.main;

import part1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part1.services.HelloService;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            HelloService service = context.getBean(HelloService.class);

            service.hello("Gigi");
        }
    }
}
