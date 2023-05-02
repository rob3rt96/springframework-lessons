package part1.main;

import part1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part1.model.Product;
import part1.repositories.ProductRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductRepository productRepository = context.getBean(ProductRepository.class);

//            Product p1 = new Product();
//            p1.setName("Beer");
//            p1.setPrice(50.99);
//
//            productRepository.addProduct(p1);

            List<Product> products = productRepository.getProducts();
            products.forEach((product) -> System.out.println(product));
        }
    }
}
