package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;

public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {       // The Context is the collection of instances about which the framework knows, and that can be used and managed by the framework.
            ProductDeliveryService service = context.getBean(ProductDeliveryService.class);

            service.addSomeProducts();
        }
    }
}
