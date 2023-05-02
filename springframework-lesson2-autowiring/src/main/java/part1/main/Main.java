package part1.main;

import part1.beans.Cat;
import part1.beans.Owner;
import part1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            Cat x = c.getBean(Cat.class);
            Owner o = c.getBean(Owner.class);

            System.out.println(x);
            System.out.println(o);
        }
    }
}
