package hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookApplicationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void availableTest() {
        String response = restTemplate.getForObject("/available", String.class);
        assertEquals("Spring in Action", response);
    }

    @Test
    public void checkoutTest() {
        String response = restTemplate.getForObject("/checked-out", String.class);
        assertEquals("Spring Boot in Action", response);
    }
}