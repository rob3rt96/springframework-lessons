package part4.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    private final Cat cat;

    @Autowired                      // Here @Autowired injects the instance of Cat, from the Spring Context, into the constructor's parameter.
    public Owner(@Qualifier("cat2") Cat cat) {
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
