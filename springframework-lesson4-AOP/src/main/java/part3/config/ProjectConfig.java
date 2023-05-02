package part3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"part3.services", "part3.aspects"})
@EnableAspectJAutoProxy                     // We have to enable aspects when we want to use them
public class ProjectConfig {

}
