package part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import part2.beans.Cat;
import part2.beans.Owner;

@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat c = new Cat();
        c.setName("Tommy");

        return c;
    }

    @Bean
    public Owner owner(Cat cat) {       // Spring knows that when you have a parameter of a method annotated with @Bean, to take a value from the Context if there is one and pass it to the method needing it
        Owner owner = new Owner();
        owner.setCat(cat);

        return owner;
    }
}
