package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional                                      // This annotation makes possible to wrap this method in a transaction. The PlatformTransactionManager will manage the execution of this method.
    public void addOneProduct() {                       // If an operation in the method throws an Exception, the PlatformTransactionManager will perform a roll-back to undo all the processes before the Exception that happened.
        productRepository.addProduct("Apple");
//        throw new RuntimeException(":(");
    }
}
