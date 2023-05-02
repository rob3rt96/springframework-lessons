package part2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"part2.services", "part2.aspects"})
@EnableAspectJAutoProxy                     // We have to enable aspects when we want to use them
public class ProjectConfig {

}
