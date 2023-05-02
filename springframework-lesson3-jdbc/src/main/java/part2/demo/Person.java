package part2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component                  // This annotation makes the instance of Person to be part of the Spring Context of the application
public class Person {

    @Autowired
    @Qualifier("es")
    private HelloService helloService;

    public void sayHello(String name) {
        String message = helloService.sayHello(name);

        System.out.println(message);
    }
}
