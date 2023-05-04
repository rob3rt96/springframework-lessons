package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    /**
     * Types of Isolation levels:
     * DEFAULT - It means that the isolation level is not declared in the Transaction, and it is taken from the underlayer, i.e. from the Database. (It is usually the READ_COMMITTED).
     * READ_UNCOMMITTED - If we have two transactions, an outer one (T1) and an inner one (T2), T2 can change the value received from T1 and then roll-back. But in the meantime T1 got to use the new value, even if it wasn't committed to the database.
     * READ_COMMITTED - If we have two transactions, an outer one (T1) and an inner one (T2), T2 can change the value received from T1 and then commit to the database. But then T1 if it wants to use again the value, it will be different from what it was some moments ago.
     * REPEATABLE_READ
     * SERIALIZABLE
     *
     * Problems when we need Isolation to resolve them:
     * - dirtu reads    (If we want to prevent this, we could use the READ_COMMITTED)
     * - repeatable reads   (If we want to prevent this and as well "dirty reads", we could use the REPEATABLE_READ)
     * - phantom reads      (If we want to prevent this, we could use SERIALIZABLE)
     */
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addTenProducts() {
        for (int i = 0; i < 10; i++) {
            productRepository.addProduct("Product " + i);
        }
    }
}
