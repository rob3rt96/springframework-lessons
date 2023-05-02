package part4.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import part4.beans.Cat;

@Configuration
@ComponentScan(basePackages = "part4.beans")
public class ProjectConfig {

    @Bean
    @Qualifier("cat1")
    public Cat cat1() {
        Cat cat = new Cat();
        cat.setName("Mario");

        return cat;
    }

    @Bean
    @Qualifier("cat2")
    public Cat cat2() {
        Cat cat = new Cat();
        cat.setName("Alexio");

        return cat;
    }
}
