package part1.config;

import part1.beans.Cat;
import part1.beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat c = new Cat();
        c.setName("Tommy");

        return c;
    }

    @Bean
    public Owner owner() {
        Owner owner = new Owner();
        owner.setCat(cat());            // This is telling Spring to look for the Cat object in the Context. If it is already created, it will pass it to Owner. If it is not created, it will create a new Cat with "Tommy" name.

        return owner;
    }
}
