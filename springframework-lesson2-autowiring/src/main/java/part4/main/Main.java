package part4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part4.beans.Cat;
import part4.beans.Owner;
import part4.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
//            Cat x = c.getBean(Cat.class);
            Owner o = c.getBean(Owner.class);

//            x.setName("Leonard");

//            System.out.println(x);
            System.out.println(o);
        }
    }
}
