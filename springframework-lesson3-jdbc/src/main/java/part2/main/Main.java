package part2.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part2.config.ProjectConfig;
import part2.demo.Person;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            Person p1 = context.getBean(Person.class);

            p1.sayHello("Bill");
        }
    }
}
