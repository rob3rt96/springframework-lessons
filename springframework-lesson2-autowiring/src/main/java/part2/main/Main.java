package part2.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part2.beans.Cat;
import part2.beans.Owner;
import part2.config.ProjectConfig;

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
