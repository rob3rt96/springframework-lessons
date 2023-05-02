package part1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"part1.services", "part1.aspects"})
@EnableAspectJAutoProxy                     // We have to enable aspects when we want to use them
public class ProjectConfig {

}
