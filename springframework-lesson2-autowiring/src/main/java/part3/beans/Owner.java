package part3.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @Autowired              // This @Autowired tells Spring that we want an instance to be injected in this field from the Context (Or a bean from the context).
    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
