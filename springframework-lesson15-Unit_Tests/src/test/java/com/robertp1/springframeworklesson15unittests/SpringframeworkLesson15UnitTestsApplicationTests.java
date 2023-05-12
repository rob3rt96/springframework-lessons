package com.robertp1.springframeworklesson15unittests;

import com.robertp1.springframeworklesson15unittests.repositories.ProductRepository;
import com.robertp1.springframeworklesson15unittests.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class SpringframeworkLesson15UnitTestsApplicationTests {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void noProductsReturnedTest() {
        // This given() method will make ProductService bean to be injected with a mocked empty List, because the ProductRepository
        // getProductNames()'s implementation is changed to a mocked one instead of the real implementation.
        given(productRepository.getProductNames()).willReturn(Collections.emptyList());

        List<String> res = productService.getProductNamesWithEvenNumberOfChars();

        assertTrue(res.isEmpty());
    }

}
