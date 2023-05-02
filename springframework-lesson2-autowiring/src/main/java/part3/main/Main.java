package part3.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part3.beans.Cat;
import part3.beans.Owner;
import part3.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            Cat x = c.getBean(Cat.class);
            Owner o = c.getBean(Owner.class);

            x.setName("Leonard");

            System.out.println(x);
            System.out.println(o);
        }
    }
}
