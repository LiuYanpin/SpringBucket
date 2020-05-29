package geektime.spring.data.transactionpropagationdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TransactionPropagationDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void should_be_true() {
        assertTrue(true);
    }
}
