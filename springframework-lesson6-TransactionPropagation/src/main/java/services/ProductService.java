package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {
    /**
     *  REQUIRED (default) - If there is already a transaction created, it will use that one. If not, it will create a new transaction for the call to that method;
     *  REQUIRES_NEW  - If there is already a transaction created, it will always create a new one;
     *  MANDATORY  - If a method is called from an environment where there is no transaction created, it will fail by throwing an exception from the PlatformTransactionManager.
     *  NEVER  - If a method is called from an environment where there is a transaction, it will fail by throwing an exception. It will only work if there is no transaction.
     *  SUPPORTS  - If a method is called within a transaction, the method will be executed on that transaction. But if there is no transaction created, it will still execute the method, and it will not create any new transaction.
     *  NOT_SUPPORTED  - It states that the call to the method, which has this annotation, does not create a transaction and executes without needing a transaction. It will execute even if there is, or there is not, a transaction created.
     *  NESTED - A call to a method with this propagation it is creating a transaction within the existing transaction. If the nested transaction generates a process of rolling back, it will be rolled-back only the nested one. But if the outer transaction generates a rolling back, even the inner transaction will be rolled-back.
     */

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addTenProducts() {
        for (int i = 0; i < 10; i++) {
            productRepository.addProduct("Product " + i);

            if (i == 5) {
                throw new RuntimeException("ha ha ha");
            }
        }
    }
}
