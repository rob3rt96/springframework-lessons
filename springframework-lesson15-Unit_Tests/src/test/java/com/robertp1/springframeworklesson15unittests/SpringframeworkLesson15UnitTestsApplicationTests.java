package com.robertp1.springframeworklesson15unittests;

import com.robertp1.springframeworklesson15unittests.repositories.ProductRepository;
import com.robertp1.springframeworklesson15unittests.services.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringframeworkLesson15UnitTestsApplicationTests {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * @BeforeEach  (A method annotated with this will be called before each of the tests)
     * @BeforeAll   (A method annotated with this will be called one at the beginning)
     * @AfterEach
     * @AfterAll
     */

    @BeforeAll
    public static void beforeClass() {
        System.out.println(":|");
    }

    @BeforeEach
    public void before() {
        System.out.println(":)");
    }

    @Test
    void noProductsReturnedTest() {
        // This given() method will make ProductService bean to be injected with a mocked empty List, because the ProductRepository
        // getProductNames()'s implementation is changed to a mocked one instead of the real implementation.
        given(productRepository.getProductNames()).willReturn(Collections.emptyList());

        List<String> res = productService.getProductNamesWithEvenNumberOfChars();

        assertTrue(res.isEmpty());
    }

    @Test
    public void moreProductsAreFoundTest() {
        List<String> input = List.of("aa", "bbb", "cccc", "dd", "eee");

        given(productRepository.getProductNames()).willReturn(input);       // assumption

        List<String> res = productService.getProductNamesWithEvenNumberOfChars();

        assertEquals(3, res.size());                                // expectation
        // verify(productRepository, times(3)).addProduct(any());
    }

    @Test
    public void zeroProductsAreFoundTest() {
        List<String> input = List.of("aaa", "bbbbb", "c", "ddd");

        given(productRepository.getProductNames()).willReturn(input);

        List<String> res = productService.getProductNamesWithEvenNumberOfChars();

        assertEquals(0, res.size());
    }
}
